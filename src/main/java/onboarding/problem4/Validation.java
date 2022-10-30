package onboarding.problem4;

public class Validation {
    public static boolean check(String word) {
        if (word.length() > Constant.LENGTH_MAX || word.length() < Constant.LENGTH_MIN) {
            return false;
        }
        return true;
    }
}
