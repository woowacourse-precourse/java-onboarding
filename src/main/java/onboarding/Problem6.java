package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    private static final int FORM_MINIMUM_LENGTH = 1;
    private static final int FORM_MAXIMUM_LENGTH = 10000;
    private static final int Email_NICKNAME_MAXIMUM_LENGTH = 20;
    private static final String EMAIL_PATTERN = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email\\.com";
    private static final String NICKNAME_PATTERN = "[가-힣]+";

    public static List<String> solution(List<List<String>> forms) {
        if (!validateInput(forms)) return Collections.emptyList();

        return List.of("success@email.com");
    }

    private static boolean validateInput(List<List<String>> forms) {
        return validateCrewNum(forms)
                && validateEmailNickname(forms);
    }

    private static boolean validateCrewNum(List<List<String>> forms) {
        return forms.size() >= FORM_MINIMUM_LENGTH && forms.size() <= FORM_MAXIMUM_LENGTH;
    }

    private static boolean validateEmailNickname(List<List<String>> forms) {
        for (List<String> form : forms) {
            if (!validateEmail(form.get(0))) return false;
            if (!validateNickname(form.get(1))) return false;
        }
        return true;
    }

    private static boolean validateNickname(String nickname) {
        return Pattern.matches(NICKNAME_PATTERN, nickname)
                && nickname.length() < Email_NICKNAME_MAXIMUM_LENGTH;
    }

    private static boolean validateEmail(String email) {
        return Pattern.matches(EMAIL_PATTERN, email)
                && email.length() < Email_NICKNAME_MAXIMUM_LENGTH;
    }

}

