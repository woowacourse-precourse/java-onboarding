package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Set<String>> adj = new HashMap<>();

        for (List<String> f : friends) {
            String f1 = f.get(0);
            String f2 = f.get(1);

            if (!adj.containsKey(f1)) adj.put(f1, new HashSet<>());
            if (!adj.containsKey(f2)) adj.put(f2, new HashSet<>());

            adj.get(f1).add(f2);
            adj.get(f2).add(f1);
        }

        Set<String> directFriends = adj.get(user);
        Map<String, Integer> score = new HashMap<>();

        for (String person : adj.keySet()) {
            if (person.equals(user) || directFriends.contains(person)) continue;

            for (String friend : adj.get(person)) {
                if (directFriends.contains(friend)) {
                    score.put(person, score.getOrDefault(person, 0)+10);
                }
            }
        }

        for (String visitor : visitors) {
            if (directFriends.contains(visitor)) continue;
            score.put(visitor, score.getOrDefault(visitor, 0)+1);
        }

        Map<Integer, List<String>> scoreToPeople = new TreeMap<>(Comparator.reverseOrder());
        for (String person : score.keySet()) {
            int s = score.get(person);
            if (!scoreToPeople.containsKey(s)) {
                scoreToPeople.put(s, new ArrayList<>());
            }
            scoreToPeople.get(s).add(person);
        }

        List<String> answer = new ArrayList<>();
        for (int s : scoreToPeople.keySet()) {
            List<String> strings = scoreToPeople.get(s);
            Collections.sort(strings);
            for (String string : strings) {
                if (answer.size() >= 5) break;
                answer.add(string);
            }
        }

        return answer;
    }
}
