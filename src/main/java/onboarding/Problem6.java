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
            String targetEmail = form.get(0);
            String targetNickname = form.get(1);
            for (int index = 0; index < targetNickname.length() - 1; index++) {
                String target = targetNickname.substring(index, index + 2);
                if (DUPLICATION_NICKNAME.containsKey(target)) {
                    String email = DUPLICATION_NICKNAME.get(target);
                    if (!email.equals(targetEmail)) {
                        emails.add(targetEmail);
                        emails.add(email);
                    }
                }
                DUPLICATION_NICKNAME.put(target, targetEmail);
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
