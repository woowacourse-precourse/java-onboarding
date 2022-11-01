package onboarding;

import java.util.*;

public class Problem2 {
    public static StringBuilder cryptogramTranslation;
    public static String answer;

    public static String solution(String cryptogram) {
        cryptogramTranslation = new StringBuilder(cryptogram);

        while (cryptogramTranslation.length() > 1 && checkOverlap(cryptogramTranslation)) {
            removeOverlap(cryptogramTranslation);
        }

        answer = cryptogramTranslation.toString();
        return answer;
    }

    public static boolean checkOverlap(StringBuilder cryptogramTranslation) {
        for (int i = 0; i < cryptogramTranslation.length() - 1; i++) {
            if(cryptogramTranslation.charAt(i) == cryptogramTranslation.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void removeOverlap(StringBuilder cryptogramTranslation) {
        for (int i = 0; i < cryptogramTranslation.length() - 1; i++) {
            if(cryptogramTranslation.charAt(i) == cryptogramTranslation.charAt(i + 1)) {
                int idx = i + 1;
                while (idx < cryptogramTranslation.length()) {
                    if(cryptogramTranslation.charAt(i) == cryptogramTranslation.charAt(idx)) {
                        idx++;
                        continue;
                    }
                    if(cryptogramTranslation.charAt(i) != cryptogramTranslation.charAt(idx)) {
                        break;
                    }
                }

                cryptogramTranslation.delete(i, idx);
            }
        }
    }
}
