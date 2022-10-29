package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> friendMap = new HashMap<>();
        friendMap.put(user, new HashSet<>());

        for (List<String> friend : friends) {
            final String targetA = friend.get(0);
            final String targetB = friend.get(1);

            if (friendMap.containsKey(targetA)) {
                friendMap.get(targetA).add(targetB);
            } else {
                final Set<String> hashSet = new HashSet<>();
                hashSet.add(targetB);
                friendMap.put(targetA, hashSet);
            }

            if (friendMap.containsKey(targetB)) {
                friendMap.get(targetB).add(targetA);
            } else {
                final Set<String> hashSet = new HashSet<>();
                hashSet.add(targetA);
                friendMap.put(targetB, hashSet);
            }
        }

        Map<String, Integer> scores = new HashMap<>();
        for (String name : friendMap.keySet()) {
            scores.put(name, 0);
        }

        // 함께 아는 친구 +10점
        for (String follower : friendMap.get(user)) {
            for (String sameFriendUser : friendMap.get(follower)) {
                scores.put(sameFriendUser, scores.get(sameFriendUser) + 10);
            }
        }

        // 타임라인 방문 +1점
        for (String visitor : visitors) {
            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }

        return scores.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().equals(user))
                .filter(entry -> !friendMap.get(user).contains(entry.getKey()))
                .filter(entry -> entry.getValue() != 0)
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
