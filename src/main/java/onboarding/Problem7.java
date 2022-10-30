package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static boolean isFriend(String user, Set<String> friends) {
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

    private static int getUserRecommendationPoint(String friend, Map<String, Integer> pointMap) {
        Set<String> users = pointMap.keySet();
        if (users.contains(friend)) {
            return pointMap.get(friend);
        }
        pointMap.put(friend, 0);
        return 0;
    }

    private static void givePointToUserBySharingFriend(String friend, Map<String, Integer> pointMap) {
        int recommendationPointByFriend = 10;
        int recommendationPoint = getUserRecommendationPoint(friend, pointMap);

        pointMap.replace(friend, recommendationPoint + recommendationPointByFriend);
    }

    private static void giveRecommendationPointToUserBySharingFriend(Map<String, Integer> pointMap, Set<String> friendsWithUserFriend) {
        for (String friendWithUserFriend : friendsWithUserFriend) {
            givePointToUserBySharingFriend(friendWithUserFriend, pointMap);
        }
    }

    private static void giveUserRecommendationPointByVisit(String visitor, Map<String, Integer> pointMap) {
        int recommendationPointByVisitor = 2;
        int recommendationPoint = getUserRecommendationPoint(visitor, pointMap);

        pointMap.replace(visitor, recommendationPoint + recommendationPointByVisitor);
    }

    private static List<String> sortRecommendationByPoint(Map<String, Integer> pointMap) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(pointMap.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        return entryList.stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
