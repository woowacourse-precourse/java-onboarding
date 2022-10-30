package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final Map<String, Integer> friendRecommendScoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friendRelationships, List<String> userTimelineVisitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Set<String> getUserIds(List<List<String>> friends) {
        Set<String> userIds = new HashSet<>();
        friends.forEach(nestedFriends -> {
            String friendName1 = nestedFriends.get(0);
            String friendName2 = nestedFriends.get(1);
            userIds.add(friendName1);
            userIds.add(friendName2);
        });
        return userIds;
    }

    private static void initFriendRecommendScoreMap(List<List<String>> friends, List<String> userTimelineVisitors) {
        Set<String> userIds = getUserIds(friends);
        userIds.forEach(userId -> friendRecommendScoreMap.put(userId, 0));
        userTimelineVisitors.forEach(userTimelineVisitor -> friendRecommendScoreMap.put(userTimelineVisitor, 0));
    }

    private static Set<String> getUserFriends(String userId, List<List<String>> friendRelationships) {
        Set<String> userFriends = new HashSet<>();
        friendRelationships.stream()
                .filter(friendRelationship -> friendRelationship.contains(userId))
                .forEach(friendRelationship -> {
                    userFriends.add(friendRelationship.get(0));
                    userFriends.add(friendRelationship.get(1));
                });
        userFriends.remove(userId);
        return userFriends;
    }

    private static List<String> getFriendsOfUserFriends(String userId, List<List<String>> friendRelationships, Set<String> userFriends) {
        List<String> friendsOfUserFriends = new ArrayList<>();
        for (String userFriend : userFriends) {
            friendRelationships.stream()
                    .filter(friendRelationship -> friendRelationship.contains(userFriend))
                    .collect(Collectors.toList())
                    .forEach(friendRelationship -> {
                        String userFriendId1 = friendRelationship.get(0);
                        String userFriendId2 = friendRelationship.get(1);
                        if (!userFriendId1.equals(userId) && !userFriendId1.equals(userFriend)) {
                            friendsOfUserFriends.add(userFriendId1);
                        }
                        if (!userFriendId2.equals(userId) && !userFriendId2.equals(userFriend)) {
                            friendsOfUserFriends.add(userFriendId2);
                        }
                    });
        }
        return friendsOfUserFriends;
    }

    private static void friendsOfUserFriendsAddScore(List<String> friendsOfUserFriends) {
        friendsOfUserFriends.forEach(friendOfUserFriends -> {
            friendRecommendScoreMap.put(friendOfUserFriends, friendRecommendScoreMap.get(friendOfUserFriends) + 10);
        });
    }

    private static void userTimelineVisitorsAddScore(List<String> userTimelineVisitors) {
        userTimelineVisitors.forEach(userTimelineVisitor -> {
            friendRecommendScoreMap.put(userTimelineVisitor, friendRecommendScoreMap.get(userTimelineVisitor) + 1);
        });
    }

    private static List<String> getTopFiveScoreUser(Map<String, Integer> friendRecommendScoreMap, Set<String> userFriends) {
        return friendRecommendScoreMap.entrySet().stream()
                .filter(friendRecommendScoreMapEntry ->
                    (friendRecommendScoreMapEntry.getValue() != 0) &&
                            (!userFriends.contains(friendRecommendScoreMapEntry.getKey()))
                )
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(friendRecommendScoreMapEntry -> friendRecommendScoreMapEntry.getKey())
                .limit(5)
                .collect(Collectors.toList());
    }
}
