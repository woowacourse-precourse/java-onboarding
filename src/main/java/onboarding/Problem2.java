package onboarding;

import java.util.*;

public class Problem2 {
    public static StringBuilder cryptogramTranslation;
    public static String answer;

    public static String solution(String cryptogram) {
        cryptogramTranslation = new StringBuilder(cryptogram);

        while (cryptogram.length() > 0 && checkOverlap(cryptogramTranslation)) {
            removeOverlap(cryptogramTranslation);
        }

        answer = cryptogramTranslation.toString();
        return answer;
    }

    public static boolean checkOverlap(StringBuilder cryptogram) {
        return true;
    }

    public static void removeOverlap(StringBuilder cryptogram) {

    }
}
