package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static final Map<String, Integer> friendRecommendScoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
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
}
