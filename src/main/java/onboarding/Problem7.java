package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final Map<String, Integer> friendRecommendScoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friendRelationships, List<String> visitors) {
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

    private static void initFriendRecommendScoreMap(List<List<String>> friends) {
        Set<String> userIds = getUserIds(friends);
        userIds.forEach(userId -> friendRecommendScoreMap.put(userId, 0));
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

    private static List<String> getFriendsOfUserFriends(String userId, List<List<String>> friendRelationships) {
        List<String> friendsOfUserFriends = new ArrayList<>();
        Set<String> userFriends = getUserFriends(userId, friendRelationships);
        for (String userFriend : userFriends) {
            friendRelationships.stream()
                    .filter(friendRelationship -> friendRelationship.contains(userFriend))
                    .collect(Collectors.toList())
                    .forEach(friendRelationship -> {
                        String userFriendId1 = friendRelationship.get(0);
                        String userFriendId2 = friendRelationship.get(1);
                        if(!userFriendId1.equals(userId) && !userFriendId1.equals(userFriend)) {
                            friendsOfUserFriends.add(userFriendId1);
                        }
                        if(!userFriendId2.equals(userId) && !userFriendId2.equals(userFriend)) {
                            friendsOfUserFriends.add(userFriendId2);
                        }
                    });
        }
        return friendsOfUserFriends;
    }
}
