package onboarding;

import java.util.*;

public class Problem7 {
    private static List<String> userFriends = new ArrayList<>();
    private static Map<String, Integer> recommendDict = new HashMap<String, Integer>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        findFriends(user, friends);
        findAcquaintances(friends);
    }

    private static void findFriends(String user, List<List<String>> friends) {

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0) == user) {
                userFriends.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1) == user) {
                userFriends.add(friends.get(i).get(0));
            }
        }

    }

    private static void findAcquaintances(List<List<String>> friends) {
        String friendName1;
        String friendName2;

        for (List<String> friend : friends) {
            friendName1 = friend.get(0);
            friendName2 = friend.get(1);

            if (userFriends.contains(friendName1)) {
                if (recommendDict.containsKey(friendName2)) {
                    recommendDict.put(friendName2, recommendDict.get(friendName2) + 10);
                } else {
                    recommendDict.put(friendName2, 10);
                }
            } else if (userFriends.contains(friendName2)) {
                if (recommendDict.containsKey(friendName1)) {
                    recommendDict.put(friendName1, recommendDict.get(friendName1) + 10);
                } else {
                    recommendDict.put(friendName1, 10);
                }
            }
        }
    }

    private static void findVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            if (recommendDict.containsKey(visitor)) {
                recommendDict.put(visitor, recommendDict.get(visitor) + 1);
            } else {
                recommendDict.put(visitor, 1);
            }
        }
    }


}