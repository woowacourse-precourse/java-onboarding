package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {

    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;
    private static final String EMAIL_PATTERN = "\\w+@email.com$";
    private static final String KOREAN_PATTERN = "^[가-힣]+$";

    public static List<String> solution(List<List<String>> forms) {
        if (!isValidate(forms)) {
            return Collections.emptyList();
        }
        List<String> answer = List.of("answer");
        return answer;
    }

    /**
     * 제한사항을 검증하는 기능
     */
    public static boolean isValidate(List<List<String>> forms) {
        for (List<String> form : forms) {
            if (!validateForm(form)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateForm(List<String> form) {
        int size = form.size();
        String email = form.get(EMAIL);
        String nickname = form.get(NICKNAME);
        return (validateSize(size) && validateEmail(email) && validateNickname(nickname));
    }
    public static boolean validateSize(int size) {
        return (size > 0 && size < 10001);
    }

    public static boolean validateEmail(String email) {
        return (validateEmailLength(email) && validateEmailPrototype(email));
    }

    public static boolean validateEmailLength(String email) {
        return (email != null && email.length() > 10 && email.length() < 20);
    }

    public static boolean validateEmailPrototype(String email) {
        return Pattern.matches(EMAIL_PATTERN, email);
    }

    public static boolean validateNickname(String nickname) {
        return (validateNicknameLength(nickname) && validateLangOfNick(nickname));
    }

    public static boolean validateNicknameLength(String nickname) {
        return (nickname != null && nickname.length() > 0 && nickname.length() < 20);
    }

    public static boolean validateLangOfNick(String nickname) {
        return Pattern.matches(KOREAN_PATTERN, nickname);
    }
}
