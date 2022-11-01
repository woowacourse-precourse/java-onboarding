package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    private static final HashMap<String, String> DUP_REPOSITORY = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        return checkDuplication(forms);
    }

    private static List<String> checkDuplication(List<List<String>> forms) {
        HashSet<String> emailList = new HashSet<>();

        for (List<String> form: forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            int nickLength = nickname.length();
            if (checkLength(nickLength)) break;
            for (int i = 0; i < nickLength - 1; i++) {
                String letters = nickname.substring(i, i + 2);
                if (isContained(letters)) {
                    String dup_email = getDuplicatedEmail(letters);
                    if (checkEmail(email, dup_email)) {
                        emailList.add(dup_email);
                        emailList.add(email);
                    }
                } else {
                    DUP_REPOSITORY.put(letters, email);
                }
            }
        }

        return sortEmailList(emailList);
    }

    private static boolean checkLength(int nickLength) {
        if (nickLength < 2) {
            return true;
        }
        return false;
    }

    private static boolean isContained(String letters) {
        return DUP_REPOSITORY.containsKey(letters);
    }

    private static String getDuplicatedEmail(String letters) {
        return DUP_REPOSITORY.get(letters);
    }

    private static boolean checkEmail(String email, String dup_email) {
        return !dup_email.equals(email);
    }

    private static List<String> sortEmailList(HashSet<String> emailList) {
        return emailList.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
