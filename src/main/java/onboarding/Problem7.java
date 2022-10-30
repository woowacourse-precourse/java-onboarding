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

    private static List<String> getUserFriends(String userId, List<List<String>> friends) {
        return friends.stream()
                .filter(nestedFriends -> nestedFriends.contains(userId))
                .map(userFriends -> {
                    userFriends.remove(userId);
                    return userFriends.get(0);
                })
                .collect(Collectors.toList());
    }
}
