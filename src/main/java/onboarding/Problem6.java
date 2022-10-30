package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if (!validation(forms)) return Collections.emptyList();
        List<String> answer = new ArrayList<>();
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    static boolean validation(List<List<String>> forms) {
        if (forms.size() == 0 || forms.size() > 10000) return false;
        for (List<String> form : forms) {
            if (!validationForm(form)) return false;
        }
        return true;
    }

    static boolean validationForm(List<String> form) {
        if (form.size() != 2) return false;
        String email = form.get(0);
        String nickname = form.get(1);
        return validationEmail(email) && validationNickname(nickname);
    }

    static boolean validationEmail(String email) {
        if (email.length() <= 10 || email.length() >= 20) return false;
        if (!email.endsWith("@email.com")) return false;
        String id = email.substring(0, email.length() - 10);
        String regex = "^[a-zA-Z0-9]([-_.]?[0-9a-zA-Z])*$";
        return Pattern.matches(regex, id);
    }

    static boolean validationNickname(String nickname) {
        if (nickname.length() == 0 || nickname.length() >= 20) return false;
        String regex = "^[ㄱ-ㅎ가-힣]*$";
        return Pattern.matches(regex, nickname);
    }
}
