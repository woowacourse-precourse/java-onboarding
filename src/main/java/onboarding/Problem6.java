package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> dictionary = new HashMap<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);

            for (int i = 0; i < nickname.length() - 1; i++) {
                String word = nickname.substring(i, i + 2);
                dictionary.merge(word, 1, Integer::sum);
            }
        }

        List<String> duplicateWord = new ArrayList<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for (int i = 0; i < nickname.length() - 1; i++) {
                String word = nickname.substring(i, i + 2);
                dictionary.put(word, dictionary.get(word) - 1);
            }

            for (int i = 0; i < nickname.length() - 1; i++) {
                String word = nickname.substring(i, i + 2);
                if (dictionary.containsKey(word) && dictionary.get(word) != 0) {
                    duplicateWord.add(email);
                }
            }

            for (int i = 0; i < nickname.length() - 1; i++) {
                String word = nickname.substring(i, i + 2);
                dictionary.put(word, dictionary.get(word) + 1);
            }
        }

        return duplicateWord.stream()
                .distinct()
                .sorted()
                .collect(toList());
    }
}
