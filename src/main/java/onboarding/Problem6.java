package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;

        List<String> words = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (List<String> form : forms) {

            String name = form.get(1);

            int currentIndex = 0;

            while (currentIndex < name.length() - 1) {

                words.add(name.substring(currentIndex, currentIndex + 2));
                currentIndex++;
            }

        }

        Set<String> overlapWords = words.stream()
                .filter(e -> Collections.frequency(words, e) > 1)
                .collect(Collectors.toSet());

        for (List<String> form : forms) {

            String email = form.get(0);
            String name = form.get(1);

            for (String overlapWord : overlapWords) {

                if (name.contains(overlapWord)) {
                    set.add(email);
                }
            }
        }

        answer = set.stream().sorted()
                .collect(Collectors.toList());

        return answer;
    }
}
