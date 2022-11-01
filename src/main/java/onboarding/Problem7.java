package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        // A map of each user's set of direct friends found in the given friends list.
        Map<String, Set<String>> friendSets = new HashMap<>();

        // Find user's direct friend
        for (final List<String> friendship: friends) {
            if (friendship.get(0).equals(friendship.get(1))) {
                continue;
            }
            for (int i = 0, j = 1; i < 2; i++, j = 0) {
                friendSets.putIfAbsent(friendship.get(i), new HashSet<>());
                Set<String> friendSet = friendSets.get(friendship.get(i));
                friendSet.add(friendship.get(j));
            }
        }
        // A map to score friends who are not one of user's direct friends.
        Map<String, Integer> friendScore = new HashMap<>();
        
        // Give scores to anyone one of whose friend is also one of the given user's
        // friends by 10 times the number of those overlapping friends.
        for (final String u: friendSets.keySet()) {
            // Exclude the user and the user's direct friends.
            if (u.equals(user) || friendSets.get(user).contains(u)) {
                continue;
            }
            for (final String v: friendSets.get(u)) {
                if (friendSets.get(user).contains(v)) {
                    friendScore.compute(u, (k, score) -> score == null? 10: score.intValue() + 10);
                }
            }
        }
        // Give scores to visitors by the number of their visits.
        for (final String visitor: visitors) {
            // Exclude the user and the user's direct friends.
            if (visitor.equals(user) || friendSets.get(user).contains(visitor)) {
                continue;
            }
            friendScore.compute(visitor, (k, score) -> score == null? 1: score.intValue() + 1);
        }
        for (final String u: friendScore.keySet()) {
            System.out.println(u + friendScore.get(u).intValue());
        }
        List<String> subAnswer = friendScore.entrySet()
                .parallelStream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.<String, Integer>comparingByKey()))
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        List<String> answer = List.copyOf(
                subAnswer.subList(0,
                        Math.min(5, subAnswer.size())));
        return answer;
    }
}
