package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Map<String, List<String>> words = getEmailsByWord(forms);
        Set<String> answer = new HashSet<>();

        for (List<String> emails : words.values()) {
            if (emails.size() >= 2) {
                answer.addAll(emails);
            }
        }

        return answer.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static Map<String, List<String>> getEmailsByWord(List<List<String>> forms) {

        Map<String, List<String>> words = new HashMap<>();
        for (List<String> form : forms) {
            for (int i = 0; i < form.get(1).length() - 1; i++) {
                String email = form.get(0);
                String word = form.get(1).substring(i, i + 2);

                words.putIfAbsent(word, new ArrayList<>());
                words.get(word).add(email);
            }
        }
        return words;
    }
}
