package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    private static final HashMap<String, String> DUPLICATION_NICKNAME = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emails = nicknameDuplicateCheck(forms);
        return emailSort(emails);
    }

    private static HashSet<String> nicknameDuplicateCheck(List<List<String>> forms) {
        HashSet<String> emails = new HashSet<>();

        for (List<String> form : forms) {
            String userEmail = form.get(0);
            String userNickname = form.get(1);
            for (int index = 0; index < userNickname.length() - 1; index++) {
                String target = userNickname.substring(index, index + 2);
                if (DUPLICATION_NICKNAME.containsKey(target)) {
                    String email = DUPLICATION_NICKNAME.get(target);
                    if (!email.equals(userEmail)) {
                        emails.add(userEmail);
                        emails.add(email);
                    }
                }
                DUPLICATION_NICKNAME.put(target, userEmail);
            }
        }

        return emails;
    }

    private static List<String> emailSort(HashSet<String> emails) {
        return emails.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
