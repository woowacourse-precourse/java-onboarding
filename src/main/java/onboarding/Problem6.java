package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    public static HashMap<String, String> hashMap = new HashMap<>();
    public static HashSet<String> emails = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        emails = getEachListInForms(forms);
        answer = Arrays.asList(sortEmailList(emails));

        return answer;
    }

    private static HashSet<String> getEachListInForms(List<List<String>> forms) {
        for (List<String> nameAndEmailList : forms) {
            emails = checkNameDuplication(nameAndEmailList);
        }
        return emails;
    }

    private static HashSet<String> checkNameDuplication(List<String> nameAndEmail) {

        String name = nameAndEmail.get(1);
        String email = nameAndEmail.get(0);

        for (int i = 0; i < name.length() - 1; i++) {
            String key = name.substring(i, i + 2);
            //해당키가 이미 있다면
            if (hashMap.containsKey(key)) {
                String duplicateEmail = hashMap.get(key);
                emails.add(email);
                emails.add(duplicateEmail);
            } else {
                hashMap.put(key, email);
            }
        }
        return emails;
    }

    private static String[] sortEmailList(HashSet<String> emails) {
        List<String> finalEmail = emails.stream()
            .sorted()
            .collect(Collectors.toList());

        final String[] results = finalEmail.toArray(new String[0]);

        return results;

    }
}
