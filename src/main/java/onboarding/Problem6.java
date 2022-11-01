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
            String userEmail = getEmail(form);
            String userNickname = getNickname(form);
            for (int index = 0; isLastIndex(index, userNickname); index++) {
                String target = get2LetterWord(userNickname, index);
                if (isDuplicationNickname(target)) {
                    String email = findEmail(target);
                    if (isNotMine(email, userEmail)) {
                        emails.add(userEmail);
                        emails.add(email);
                    }
                }
                addDuplicationNickname(target, userEmail);
            }
        }

        return emails;
    }

    private static boolean isLastIndex(int index, String nickname) {
        return index < nickname.length() - 1;
    }

    private static String getEmail(List<String> form) {
        return form.get(0);
    }

    private static String getNickname(List<String> form) {
        return form.get(1);
    }

    private static String get2LetterWord(String nickname, int index) {
        return nickname.substring(index, index + 2);
    }

    private static boolean isDuplicationNickname(String target) {
        return DUPLICATION_NICKNAME.containsKey(target);
    }

    private static String findEmail(String target) {
        return DUPLICATION_NICKNAME.get(target);
    }

    private static boolean isNotMine(String email, String target) {
        return !email.equals(target);
    }

    private static void addDuplicationNickname(String nickname, String email) {
        DUPLICATION_NICKNAME.put(nickname, email);
    }

    private static List<String> emailSort(HashSet<String> emails) {
        return emails.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
