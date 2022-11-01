package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emails = new TreeSet<>();
        Map<String, String> partForms = new HashMap<>();

        for (List<String> elem : forms) {
            String name = elem.get(1);
            String email = elem.get(0);
            for (int i = 0; i < name.length() - 1; i++) {
                String namePart = name.substring(i, i + 2);
                if (partForms.containsKey(namePart)) {
                    emails.add(email);
                    emails.add(partForms.get(namePart));
                }
                partForms.put(namePart, email);
            }
        }
        return new ArrayList<>(emails);
    }
}
