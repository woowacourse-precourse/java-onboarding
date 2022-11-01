package onboarding.feature6;

import static onboarding.feature6.Constants.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static boolean isValidEmailAddress(String email) {
        return isValidLength(email, MIN_LENGTH_OF_EMAIL, MAX_LENGTH_OF_EMAIL) && isMatchedWithEmailRegex(email);
    }

    public static boolean isValidNickname(String nickname) {
        return isValidLength(nickname, MIN_LENGTH_OF_NICKNAME, MAX_LENGTH_OF_NICKNAME) && isKoreanNickname(nickname);
    }

    public static boolean isValidLength(String input, int minLength, int maxLength) {
        int inputLength = input.length();
        return inputLength >= minLength && inputLength < maxLength;
    }

    public static boolean isMatchedWithEmailRegex(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isKoreanNickname(String nickname) {
        for (int i = 0; i < nickname.length(); i++) {
            int decimalValueOfChar = nickname.charAt(i);
            if ((decimalValueOfChar < FIRST_VALUE_OF_HANGUL_SYLLABLES || decimalValueOfChar > LAST_VALUE_OF_HANGUL_SYLLABLES)
                && (decimalValueOfChar < FIRST_VALUE_OF_HANGUL_JAMO || decimalValueOfChar > LAST_VALUE_OF_HANGUL_JAMO)) {
                return false;
            }
        }
        return true;
    }
}
