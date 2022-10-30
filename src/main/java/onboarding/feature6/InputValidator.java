package onboarding.feature6;

import static onboarding.feature6.Constants.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static boolean emailChecker(String email) {
        return isValidLength(email, 11, 20) && isValidEmailAddress(email);
    }

    public static boolean nicknameChecker(String nickname) {
        return isValidLength(nickname, 1, 20) && isValidNickname(nickname);
    }

    public static boolean isValidLength(String input, int minLength, int maxLength) {
        int inputLength = input.length();
        return inputLength >= minLength && inputLength < maxLength;
    }

    public static boolean isValidEmailAddress(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidNickname(String nickname) {
        for (int i = 0; i < nickname.length(); i++) {
            int unicodeDecimal = nickname.charAt(i);
            if ((unicodeDecimal < 44032 || unicodeDecimal > 55203) && (unicodeDecimal < 12593 || unicodeDecimal > 12643)) {
                return false;
            }
        }
        return true;
    }
}
