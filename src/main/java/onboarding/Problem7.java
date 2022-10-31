package onboarding;

import java.util.*;
import java.util.stream.Collectors;

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

        for (List<String> friend : friends) {
            friendsRelation = friend;
            usersFriendIndex = getUsersFriendIndex(user, friendsRelation);
            if (usersFriendIndex != -1) {
                usersFriends.add(friendsRelation.get(usersFriendIndex));
                continue;
            }
            friendsShouldCheck.add(friendsRelation);
        }
        usersFriends.remove(user);
    }

    private static void addPoint(Map<String, Integer> friendAndScore, String friend, int point) {
        if (friendAndScore.containsKey(friend)) {
            friendAndScore.put(friend, friendAndScore.get(friend) + point);
        }
        friendAndScore.put(friend, point);
    }

    private static void checkFriends(Map<String, Integer> friendAndScore, List<List<String>> friends, Set<String> usersFriends) {
        List<String> friendsRelation;

        for (List<String> friend : friends) {
            friendsRelation = friend;
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
        for (String visitor : visitors) {
            if (!usersFriends.contains(visitor)) {
                addPoint(friendAndScore, visitor, VISITOR_POINT);
            }
        }
    }

    private static List<String> returnTopFiveFriends(Map<String, Integer> friendAndScore){
        List<Map.Entry<String, Integer>> friendAndScoreList = new LinkedList<>(friendAndScore.entrySet());
        List<String> recommendList;
        friendAndScoreList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        recommendList = friendAndScoreList.stream().limit(MAX_RECOMMEND_SIZE).map(Map.Entry::getKey).collect(Collectors.toList());
        return recommendList;
    }

    static List<String> returnRecommendList(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendAndScore = new HashMap<>();
        List<List<String>> friendsShouldCheck = new ArrayList<>();
        Set<String> usersFriends = new HashSet<>();

        distinguishUsersFriend(user, friends, usersFriends, friendsShouldCheck);
        checkFriends(friendAndScore, friendsShouldCheck, usersFriends);
        checkVisitors(friendAndScore, visitors, usersFriends);
        return returnTopFiveFriends(friendAndScore);
    }

}