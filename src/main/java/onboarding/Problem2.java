package onboarding;

import java.util.LinkedHashSet;
import java.util.Set;

public class Problem2 {
    public static String solution(String cryptogram) {
        return deleteContinuousDuplicated(cryptogram);
    }

    public static String deleteContinuousDuplicated(String cryptogram) {
        if (cryptogram.length() == 0) {
            return cryptogram;
        }

        return null;
    }
}
