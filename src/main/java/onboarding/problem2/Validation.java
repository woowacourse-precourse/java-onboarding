package onboarding.problem2;

import static java.lang.Character.isUpperCase;

public class Validation {
    public static boolean isOutOfRange(String cryptogram) {
        return cryptogram.length() < 1 || cryptogram.length() > 1000;
    }

    public static String checkValidForm(char alphabet) {
        if (isUpperCase(alphabet)) {
            return "문자열 형식이 잘못되었습니다.";
        }
        return null;
    }
}
