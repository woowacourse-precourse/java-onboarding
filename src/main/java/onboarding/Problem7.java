package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, List<String>> friendsMap = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> userFriend = makeUserFriends(user, friends);
        Map<String, Integer> recommendList = makeRecommendList(user, friends, userFriend);

        List<String> answer = Collections.emptyList();
        return answer;
    }
    private static List<String> makeUserFriends(String user, List<List<String>> friends) {
        List<String> userFriend = new ArrayList<>();
        for(List<String> friend : friends) {
            if(friend.contains(user)) {
                for (String name : friend) {
                    if (name.equals(friend.get(0))) {
                        userFriend.add(friend.get(1));
                    } else {
                        userFriend.add(friend.get(0));
                    }
                }
            }
        }
        return userFriend;
    }
    private static Map<String, Integer> makeRecommendList(String user, List<List<String>> friends, List<String> userFriend) {
        Map<String, Integer> recommendList = new HashMap<>();
        //user 가 아니고, user 친구가 아닌 사람들
        for(List<String> friend : friends) {
            for(String name : userFriend) {
                if(friend.get(0).equals(name)) {
                    recommendList.put(friend.get(1), recommendList.get(friend.get(1)) + 10);
                }
            }
        }
        return recommendList;
    }

    private static void addVisitorsScore(Map<String, Integer> recommendList, List<String> userFrined, List<String> visitors) {
        for(String visitor : visitors) {
            if(!userFrined.contains(visitor)) {
                recommendList.put(visitor, recommendList.get(visitor) + 1);
            }
        }
    }

}