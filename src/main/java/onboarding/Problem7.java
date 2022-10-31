package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, List<String>> friendsMap = new HashMap<>();
    private static Map<String, Integer> friendsScore = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initFriends(friends);

        List<String> userFriends = getUserFriends(user);
        for (String userFriend : userFriends) {
            addFriendsScore(user, userFriend);
        }

        addVisitScore(visitors);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void initFriends(List<List<String>> friends) {

        for (int i = 0; i < friends.size(); i++) {
            List<String> friendShip = friends.get(i);
            String friend1 = friendShip.get(0);
            String friend2 = friendShip.get(1);

            if (friendsMap.get(friend1) == null) {
                friendsMap.put(friend1, new ArrayList<>());
            }

            if (friendsMap.get(friend2) == null) {
                friendsMap.put(friend2, new ArrayList<>());
            }

            friendsMap.get(friend1).add(friend2);
            friendsMap.get(friend2).add(friend1);
        }

    }

    private static List<String> getUserFriends(String user) {
        return friendsMap.get(user);
    }

    private static void addFriendsScore(String user, String userFriend) {
        List<String> friendNames = getUserFriends(userFriend);
        for (String friendName : friendNames) {

            if (!user.equals(friendName)) {
                addScore(friendName, 10);
            }

        }
    }

    private static void addVisitScore(List<String> visitors) {
        for (String visitor : visitors) {
            addScore(visitor, 1);
        }
    }

    private static void addScore(String name, int score) {
        friendsScore.put(name, friendsScore.getOrDefault(name, 0) + score);
    }

    private static List<Map.Entry<String, Integer>> getSortList() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(friendsScore.entrySet());
        Collections.sort(entries, (friend1, friend2) -> {

            if (friend1.getValue() > friend2.getValue()) {
                return -1;
            } else if (friend1.getValue() == friend2.getValue()) {
                return friend1.getKey().compareTo(friend2.getKey());
            } else {
                return 1;
            }

        });

        return entries;
    }

}
