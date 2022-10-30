package onboarding;

import java.util.*;

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
}
