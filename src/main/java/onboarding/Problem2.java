package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decode(cryptogram);
    }

    private static boolean isDecoded(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) return false;
        }
        return true;
    }

    private static String decode(String cryptogram) {
        if (isDecoded(cryptogram)) {
            return cryptogram;
        }
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                String next = cryptogram.replaceAll("(([a-z])\\2{1,})", "");
                return decode(next);
            }
        }
        return "error";
    }
}
