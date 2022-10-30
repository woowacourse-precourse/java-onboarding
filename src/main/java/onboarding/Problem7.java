package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static boolean isFriend(String user, List<String> friends) {
        return friends.stream()
                .anyMatch(friend -> friend.equals(user));
    }

    private static void saveFriend(Map<String, Set<String>> friendsMap, List<String> friends) {
        String user1 = friends.get(0);
        String user2 = friends.get(1);
        Set<String> user1Friends = getFriends(user1, friendsMap);
        Set<String> user2Friends = getFriends(user2, friendsMap);

        user1Friends.add(user2);
        user2Friends.add(user1);
    }

    private static Set<String> getFriends(String user, Map<String, Set<String>> friendsMap) {
        Set<String> users = friendsMap.keySet();
        if (users.contains(user)) {
            return friendsMap.get(user);
        }
        Set<String> userFriends = new HashSet<>();
        friendsMap.put(user, userFriends);
        return userFriends;
    }

    private static Set<String> getFriendsByUserFriend(String userFriend, Map<String, Set<String>> friendsMap) {
        return friendsMap.get(userFriend);
    }

    private static void giveRecommendationPointToUser(String friend, Map<String, Integer> pointMap) {
        int recommendationPointOfFriend = 10;
        int friendPoint = getUserRecommendationPoint(friend, pointMap);

        pointMap.replace(friend, friendPoint + recommendationPointOfFriend);
    }

    private static int getUserRecommendationPoint(String friend, Map<String, Integer> pointMap) {
        Set<String> users = pointMap.keySet();
        if (users.contains(friend)) {
            return pointMap.get(friend);
        }
        pointMap.put(friend, 0);
        return 0;
    }
}
