package onboarding.problem6;

import java.util.regex.Pattern;

public final class Validator {

    public static boolean isValidEmail(String email) {
        int atIdx = email.indexOf("@");
        if (atIdx == -1) {
            return false;
        }

        String domain = email.substring(atIdx + 1);
        if (!domain.equals("email.com")) {
            return false;
        }

        return (11 <= email.length()) && (email.length() < 20);
    }

    public static boolean isValidName(String name) {
        int length = name.length();
        if (length < 1 || length >= 20) {
            return false;
        }

        return Pattern.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]*$", name);
    }

}
