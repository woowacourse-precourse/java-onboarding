package onboarding;

import java.util.*;

public class Problem6 {
    private static final int EMAIL_INDEX = 0;
    private static final int NAME_INDEX = 1;

    public static List<String> solution(List<List<String>> forms) {
        return findSimilarNames(forms);
    }

    private static List<String> findSimilarNames(List<List<String>> forms) {
        HashMap<String, List<String>> pairs = new HashMap<>();
        List<String> answer = new ArrayList<>();

        for (List<String> form : forms) {
            String email = form.get(EMAIL_INDEX);
            String name = form.get(NAME_INDEX);
            putContinuousName(pairs, email, name);
        }
        addValue(pairs, answer);
        return new ArrayList<>(new TreeSet<>(answer));
    }

    private static void addValue(HashMap<String, List<String>> pairs, List<String> answer) {
        for (List<String> value : pairs.values()) {
            if (value.size() > 1) {
                answer.addAll(value);
            }
        }
    }

    private static void putContinuousName(HashMap<String, List<String>> pairs, String email, String name) {
        for (int i = 0; i < name.length() - 1; i++) {
            List<String> emailCharacters = new ArrayList<>(List.of(email));
            String subName = name.substring(i, i + 2);

            if (pairs.containsKey(subName)) {
                List<String> strings = pairs.get(subName);
                emailCharacters.addAll(strings);
            }
            pairs.put(subName, emailCharacters);
        }
    }
}
