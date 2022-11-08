package onboarding.problem4;

public class Validation {
    public static boolean isOutOfRange(String word) {
        return word.length() < 1 || word.length() > 1000;
    }
}
