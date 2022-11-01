package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> userFriends = new HashSet<>();
        userFriends.add(user);
        for (List<String> friendship : friends) {
            String friend1 = friendship.get(0);
            String friend2 = friendship.get(1);
            if (friend1.equals(user)) {
                userFriends.add(friend2);
            }
            if (friend2.equals(user)) {
                userFriends.add(friend1);
            }
        }

        Map<String, Integer> recommendScore = new HashMap<>();
        for (List<String> friendship : friends) {
            String friend1 = friendship.get(0);
            String friend2 = friendship.get(1);
            if (!userFriends.contains(friend1) && userFriends.contains(friend2)) {
                recommendScore.putIfAbsent(friend1, 0);
                recommendScore.put(friend1, recommendScore.get(friend1) + 10);
            }
            if (!userFriends.contains(friend2) && userFriends.contains(friend1)) {
                recommendScore.putIfAbsent(friend2, 0);
                recommendScore.put(friend2, recommendScore.get(friend2) + 10);
            }
        }

        for (String visitor : visitors) {
            if (!userFriends.contains(visitor)) {
                recommendScore.putIfAbsent(visitor, 0);
                recommendScore.put(visitor, recommendScore.get(visitor) + 1);
            }
        }

        List<String> candidates = new ArrayList<>(recommendScore.keySet());
        candidates.sort((o1, o2) -> {
            if (!Objects.equals(recommendScore.get(o1), recommendScore.get(o2))) {
                return recommendScore.get(o2).compareTo(recommendScore.get(o1));
            } else {
                return o1.compareTo(o2);
            }
        });

        return candidates.subList(0, Math.min(candidates.size(), 5));
    }
}
