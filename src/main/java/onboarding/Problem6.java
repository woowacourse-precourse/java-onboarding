package onboarding;

import java.util.*;

public class Problem6 {
    static Map<String, Set<String>> duplicatedForms = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            if (nickname.length() < 2) {
                continue;
            }
            addNickwords(email, nickname);

        }
        Set<String> answer = new HashSet<>();
        for (Set<String> emails : duplicatedForms.values()) {
            if (emails.size() < 2) {
                continue;
            }
            answer.addAll(emails);
        }
        return List.copyOf(answer);

    }

    private static void addNickwords(String email, String nickname) {
        for (int i = 1; i < nickname.length(); i++) {
            String nickwords = nickname.substring(i - 1, i + 1);
            Set<String> emailSet = duplicatedForms.getOrDefault(nickwords, new HashSet<>());
            emailSet.add(email);
            duplicatedForms.put(nickwords, emailSet);
        }
    }
}
