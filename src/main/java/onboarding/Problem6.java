package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> tokens = new HashMap<>();
        countEachToken(forms, tokens);

        List<String> emails = new ArrayList<>();
        tokens.forEach((k, v) -> {
            forms.forEach(ls -> {
                if (ls.get(1).contains(k) && v > 1 && !emails.contains(ls.get(0))) {
                    // nickname contains token AND
                    // token's count is bigger than 1 AND
                    // emails does not contain this email address
                    emails.add(ls.get(0));
                }
            });
        });

        Collections.sort(emails);

        return emails;
    }

    /**
     * tokenize each nickname with a token of length 2 and
     * count how many times it appears
     * tokens.get(token) returns count of token
     * @param forms
     * @param tokens
     */
    static void countEachToken(List<List<String>> forms, Map<String, Integer> tokens) {
        for (List<String> ls : forms) {
            String name = ls.get(1);
            for (int i = 0; i < name.length() - 1; i++) {
                String token = name.substring(i, i + 2);

                if (tokens.containsKey(token)) {
                    tokens.put(token, tokens.get(token) + 1);
                } else {
                    tokens.put(token, 1);
                }
            }
        }
    }
}
