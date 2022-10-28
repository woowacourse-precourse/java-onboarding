package onboarding.problem2;

import java.util.regex.Pattern;

public class Validation {
    static final String VALIDATION_REGEX = "[a-z]*$";
    static final int LENGTH_UPPERBOUND = 1000;
    static final int LENGTH_LOWERBOUND = 1;
    public static boolean check(String cryptogram) {
        if (cryptogram.length() > LENGTH_UPPERBOUND || cryptogram.length() < LENGTH_LOWERBOUND) {
            return false;
        } else if (!Pattern.matches(VALIDATION_REGEX, cryptogram)) {
            return false;
        }
        return true;
    }
}
