package onboarding.feature4;

public class AlphabetValidator {
    public static boolean isUppercase(Character letter) {
        if (letter >= 'A' && letter <= 'Z') {
            return true;
        }
        return false;
    }

    public static boolean isLowercase(Character letter) {
        if (letter >= 'a' && letter <= 'z') {
            return true;
        }
        return false;
    }
}
