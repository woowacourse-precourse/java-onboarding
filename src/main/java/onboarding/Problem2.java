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
        char prevWord = cryptogramTranslation.charAt(0);
        int prevIdx = 0;

        for (int i = 0; i < cryptogramTranslation.length() - 1; i++) {
            int idx = i + 1;
            if(prevWord == cryptogramTranslation.charAt(idx)) {
                return true;
            }
        }
        return false;
    }

    public static void removeOverlap(StringBuilder cryptogram) {

    }

    class Point {
        int prev;
        int next;

        public Point(int prev, int next) {
            this.prev = prev;
            this.next = next;
        }
    }
}
