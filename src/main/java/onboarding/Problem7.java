package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> alreadyFriends = getAlreadyFriends(friends);
        Map<String, Integer> recommendPoint = getRecommendPoint(friends, user);

        return Arrays.asList("", "");
    }

    private static Set<String> getAlreadyFriends(List<List<String>> friends) {
        Set<String> alreadyFriends = new HashSet<>();

        for (List<String> friend : friends) {
            alreadyFriends.add(friend.get(0));
        }

        return alreadyFriends;
    }


    private static Map<String, Integer> getRecommendPoint(List<List<String>> friends, String user) {
        Map<String, Integer> recommendPoint = new HashMap<>();

        for (List<String> friend : friends) {
            String newFriend = friend.get(1);

            if (!user.equals(newFriend)) {
                recommendPoint.put(newFriend, recommendPoint.getOrDefault(newFriend, +10));
            }
        }

        return recommendPoint;
    }

}
