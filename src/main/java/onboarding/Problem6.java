package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;
    private static final String EMAIL_FORM = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@email.com$";
    private static final String HANGEUL = "^[ㄱ-ㅎ가-힣]*$";
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if (!verifyException(forms)) {
            return List.of("Error");
        }
        return answer;
    }

    private static boolean verifyException(List<List<String>> forms) {
        for (List<String> form: forms) {
            if (!checkSizeCrew(form)) {
                return false;
            }
            if (!checkEmail(form.get(EMAIL)) || !checkNickname(form.get(NICKNAME))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSizeCrew(List<String> form) {
        return (form.size() >= 1 && form.size() <= 10000);
    }

    private static boolean checkEmail(String email) {
        return (isValidLength(email) && isValidEmail(email));
    }

    private static boolean isValidLength(String email) {
        return (email.length() >= 11 && email.length() < 20);
    }

    private static boolean isValidEmail(String email) {
        return (Pattern.matches(EMAIL_FORM, email));
    }

    private static boolean checkNickname(String nickname) {
        return (Pattern.matches(HANGEUL, nickname));
    }

}
