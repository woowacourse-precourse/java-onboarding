package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    public static HashSet<String> emails = new HashSet<>();
    public static HashMap<String, String> nameAndEmail = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for (List<String> nameAndEmailList : forms) {
            checkDuplication(nameAndEmailList);
        }
        answer = sortEmailList(emails);
        return answer;
    }

    private static HashSet<String> checkDuplication(List<String> nameAndEmail) {

        String name = nameAndEmail.get(1);
        String email = nameAndEmail.get(0);

        for (int i = 0; i < name.length() - 1; i++) {
            String key = name.substring(i, i + 2);
            emails = checkNameDuplication(key, email);
        }
        return emails;
    }

    private static HashSet<String> checkNameDuplication(String key, String email) {
        if (nameAndEmail.containsKey(key)) {
            String duplicateEmail = nameAndEmail.get(key);
            emails.add(duplicateEmail);
            emails.add(email);
        } else {
            nameAndEmail.put(key, email);
        }
        return emails;
    }

    private static List<String> sortEmailList(HashSet<String> emails) {
        List<String> finalEmail = emails.stream()
            .sorted()
            .collect(Collectors.toList());

        return finalEmail;
    }
}
