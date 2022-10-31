package onboarding.problem2;

import java.util.regex.Pattern;

public class Validation {
    public static boolean check(String cryptogram) {
        if (cryptogram.length() > Constant.LENGTH_UPPERBOUND || cryptogram.length() < Constant.LENGTH_LOWERBOUND) {
            return false;
        } else if (!Pattern.matches(Constant.VALIDATION_REGEX, cryptogram)) {
            return false;
        }
        return true;
    }
}
