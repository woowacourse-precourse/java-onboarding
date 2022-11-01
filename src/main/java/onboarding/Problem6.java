package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> emails = new ArrayList<>(compareAllName(forms));
        Collections.sort(emails);
        return emails;
    }

    private static boolean isSimilar(String name1, String name2) {
        for (int i = 0; i < name1.length() - 1; i++) {
            if (name2.contains(name1.substring(i, i+2)))
                return true;
        }

        return false;
    }

    private static Set<String> compareAllName(List<List<String>> forms) {
        Set<String> emails = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String srcEmail = forms.get(i).get(0);
            String srcName = forms.get(i).get(1);
            if (invalidNickname(srcName) || invalidEmail(srcEmail))
                continue;
            for (int j = i+1; j < forms.size(); j++) {
                String targetEmail = forms.get(j).get(0);
                String targetName = forms.get(j).get(1);
                if (invalidNickname(targetName) || invalidEmail(targetEmail))
                    continue;
                if (srcEmail.equals(targetEmail)) continue;
                if (isSimilar(srcName, targetName)) {
                    emails.add(srcEmail);
                    emails.add(targetEmail);
                }
            }
        }
        return emails;
    }

    private static boolean invalidEmail(String email) {
        if (email.length() < 11 || email.length() > 19)
            return true;

        String emailPattern = "^\\w+@email.com$";
        return !Pattern.matches(emailPattern, email);
    }


    private static boolean invalidNickname(String nickname) {
        if (nickname.length() >= 20)
            return true;

        String nicknamePattern = "^[가-힣]+$";

        return !Pattern.matches(nicknamePattern, nickname);
    }
}
