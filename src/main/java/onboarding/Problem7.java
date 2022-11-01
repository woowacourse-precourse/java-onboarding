package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Set<String>> relationships = makeRelationships(friends);
        Map<String, Integer> scores = new HashMap<>();
        Set<String> myfriends = relationships.get(user);

        for (String myFriend : myfriends) {
            for (String recomm : relationships.get(myFriend)) {
                if (recomm.equals(user) || myfriends.contains(recomm)) {
                    continue;
                }
                if (scores.containsKey(recomm)) {
                    scores.put(recomm, scores.get(recomm) + 10);
                } else {
                    scores.put(recomm, 10);
                }
            }
        }


        for (String visitor : visitors) {
            if (!myfriends.contains(visitor)) {
                if (scores.containsKey(visitor)) {
                    scores.put(visitor, scores.get(visitor) + 1);
                } else {
                    scores.put(visitor, 1);
                }
            }
        }
        List<String> answer = scores.keySet().stream()
            .sorted((name, score) -> scores.get(score).compareTo(scores.get(name)))
            .limit(5)
            .collect(Collectors.toList());
        return answer;
    }

    public static Map<String, Set<String>> makeRelationships(List<List<String>> friends) {
        Map<String, Set<String>> relationships = new HashMap<>();
        for (List<String> relation : friends) {
            String friendA = relation.get(0);
            String friendB = relation.get(1);

            Set<String> set1 = new HashSet<>();
            Set<String> set2 = new HashSet<>();

            if (relationships.containsKey(friendA)) {
                set1 = relationships.get(friendA);
                set1.add(friendB);
            } else {
                set1.add(friendB);
            }
            relationships.put(friendA, set1);
            if (relationships.containsKey(friendB)) {
                set2 = relationships.get(friendB);
                set2.add(friendA);
            } else {
                set2.add(friendA);
            }
            relationships.put(friendB, set2);
        }
        return relationships;
    }

}
