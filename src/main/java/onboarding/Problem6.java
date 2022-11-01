package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> subAnswer = new HashSet<>();

        // A map to count all possible substrings of names.
        HashMap<String, Integer> numSubNames = new HashMap<>();
        for (final List<String> form: forms) {
            final String name = form.get(1);
            for (int i = 0; i < name.length(); i++) {
                for (int j = i + 2; j <= name.length(); j++) {
                    final String subName = name.substring(i, j);
                    numSubNames.compute(subName, (k, v) -> v == null? 1: v + 1);
                }
            }
        }
        // Remove subnames whose length is 1 from the map.
        for (final String subName: Set.copyOf(numSubNames.keySet())) {
            if (numSubNames.get(subName).intValue() == 1) {
                numSubNames.remove(subName);
            }
        }
        // Find unique emails any of whose subnames are already in the map.
        for (final List<String> form: forms) {
            final String email = form.get(0),
                    name = form.get(1);
            boolean found = false;
            for (int i = 0; !found && i < name.length(); i++) {
                for (int j = i + 2; !found && j <= name.length(); j++) {
                    final String subName = name.substring(i, j);
                    if (numSubNames.containsKey(subName)) {
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                subAnswer.add(email);
            }
        }
        List<String> answer = subAnswer.parallelStream()
                .collect(Collectors.toList());
        return answer;
    }
}
