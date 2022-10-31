package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> words = new HashMap<>();
        TreeSet<String> emails = new TreeSet<>();
        String word;
        for (List<String> form : forms) {
            for (int i = 0; i < form.get(1).length() - 1; i++) {
                word = form.get(1).substring(i, i + 2);
                if (words.containsKey(word)) {
                    emails.add(words.get(word));
                    emails.add(form.get(0));
                } else {
                    words.put(word, form.get(0));
                }
            }
        }
        return new ArrayList<>(emails);
    }
}
