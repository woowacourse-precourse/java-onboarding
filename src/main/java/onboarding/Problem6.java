package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        final Map<String, List<String>> dictionary = initDictionary(new HashMap<>(), forms);

        return Collections.emptyList();
    }

    private static Map<String, List<String>> initDictionary(
            Map<String, List<String>> dictionary,
            List<List<String>> forms
    ) {
        for (List<String> form : forms) {
            for (int i = 0; i < form.get(1).length() - 1; i++) {
                String word = form.get(1).substring(i, i + 2);

                if (!dictionary.containsKey(word)) {
                    dictionary.put(word, new ArrayList<>());
                }

                dictionary.get(word).add(form.get(0));
            }
        }

        return dictionary;
    }
}
