package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> nameToEmails = new HashMap<>();

        for (List<String> item : forms) {
            String email = item.get(0);
            String name = item.get(1);
            updateMap(nameToEmails, email, name);
        }
        return nameToEmails.entrySet().stream()
                .filter(item -> item.getValue().size() > 1)
                .flatMap(item -> item.getValue().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static void updateMap(Map<String, List<String>> nameToEmails,
                                  String email,
                                  String name) {
        for (int i = 0; i < name.length() - 1; i++) {
            String subStr = name.substring(i, i + 2);
            if (!nameToEmails.containsKey(subStr)) {
                nameToEmails.put(subStr, new ArrayList<>());
            }
            nameToEmails.get(subStr).add(email);
        }
    }
}