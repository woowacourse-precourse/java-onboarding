package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emails = new HashSet<>();
        Map<String, String> keywords = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            if (validEmail(email) && validNickname(nickname)) {
                for (int i = 0; i < nickname.length() - 1; i++) {
                    String key = nickname.substring(i, i + 2);
                    if (keywords.containsKey(key)) {
                        String hashEmail = keywords.get(key);
                        if (!hashEmail.equals(email)) {
                            emails.add(email);
                            emails.add(hashEmail);
                        }
                    }
                    keywords.put(key, email);
                }
            }
        }

        List<String> answer = emails.stream()
            .sorted()
            .collect(Collectors.toList());

        return answer;
    }

    public static boolean validNickname(String nickname) {
        if (!Pattern.matches("^[가-힣]*$", nickname)) {
            return false;
        }
        if (nickname.length() < 1 || nickname.length() > 19) {
            return false;
        }
        return true;
    }

    public static boolean validEmail(String email) {
        if (email.length() < 11 || email.length() > 19) {
            return false;
        }
        int idxAt = email.indexOf('@',1);
        if (idxAt == -1) {
            return false;
        }
        if (!email.substring(idxAt + 1, email.length()).equals("email.com")) {
            return false;
        }
        return true;
    }
}
