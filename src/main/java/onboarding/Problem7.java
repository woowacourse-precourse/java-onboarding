package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        answer = FriendInfoController.returnRecommendList(user, friends, visitors);
        return answer;
    }
}

class FriendInfoController {
    static final int MAX_RECOMMEND_SIZE = 5;
    static final int SAME_FRIEND_POINT = 10;
    static final int VISITOR_POINT = 1;

    private static int getUsersFriendIndex(String user, List<String> friendsRelation) {
        if (friendsRelation.get(0).equals(user)) {
            return 1;
        }
        if (friendsRelation.get(1).equals(user)) {
            return 0;
        }
        return -1;
    }

    private static void distinguishUsersFriend(String user, List<List<String>> friends, Set<String> usersFriends, List<List<String>> friendsShouldCheck) {
        List<String> friendsRelation;
        int usersFriendIndex;

        for (int i =0; i < friends.size(); i++) {
            friendsRelation= friends.get(i);
            usersFriendIndex = getUsersFriendIndex(user, friendsRelation);
            if(usersFriendIndex != -1) {
                usersFriends.add(friendsRelation.get(usersFriendIndex));
                continue;
            }
            friendsShouldCheck.add(friendsRelation);
        }
    }

    private static void addPoint(Map<String, Integer> friendAndScore, String friend, int point) {
        if (friendAndScore.containsKey(friend)) {
            friendAndScore.put(friend, friendAndScore.get(friend) + point);
        }
        friendAndScore.put(friend, point);
    }

    private static void checkFriends(Map<String, Integer> friendAndScore, List<List<String>> friends, Set<String> usersFriends) {
        List<String> friendsRelation;

        for (int i = 0; i < friends.size(); i++) {
            friendsRelation = friends.get(i);
            if (usersFriends.contains(friendsRelation.get(0))
                    && !usersFriends.contains(friendsRelation.get(1))) {
                addPoint(friendAndScore, friendsRelation.get(1), SAME_FRIEND_POINT);
                continue;
            }
            if (usersFriends.contains(friendsRelation.get(1))
                    && !usersFriends.contains(friendsRelation.get(0))) {
                addPoint(friendAndScore, friendsRelation.get(0), SAME_FRIEND_POINT);
            }
        }
    }

    private static void checkVisitors(Map<String, Integer> friendAndScore, List<String> visitors, Set<String> usersFriends) {
        for (int i = 0; i < visitors.size(); i++) {
            if(!usersFriends.contains(visitors.get(i))) {
                addPoint(friendAndScore, visitors.get(i), VISITOR_POINT);
            }
        }
    }

    private static List<String> returnTopFiveFriends(Map<String, Integer> friendAndScore){
        List<Map.Entry<String, Integer>> friendAndScoreList = new LinkedList<>(friendAndScore.entrySet());
        List<String> recommendList = new ArrayList<>();
        friendAndScoreList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<String, Integer> friend : friendAndScoreList) {
            recommendList.add(friend.getKey());
            if (recommendList.size() == MAX_RECOMMEND_SIZE){
                break;
            }
        }
        return recommendList;
    }

    static List<String> returnRecommendList(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> recommendMap = new HashMap<>();
        List<List<String>> friendsShouldCheck = new ArrayList<>();
        Set<String> usersFriends = new HashSet<>();

        distinguishUsersFriend(user, friends, usersFriends, friendsShouldCheck);
        checkFriends(recommendMap, friendsShouldCheck, usersFriends);
        checkVisitors(recommendMap, visitors, usersFriends);
        return returnTopFiveFriends(recommendMap);
    }

}