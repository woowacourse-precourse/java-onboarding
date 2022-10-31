package onboarding;

import java.util.Stack;

public class Problem2 {
    public static boolean areThereDuplicateCharacters(String cryptogram) {
        for (int i = 0; i + 1 < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) return true;
        }
        return false;
    }

    public static String deleteDuplicateCharacters(String cryptogram) {
        String result = new String();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (i > 0 && cryptogram.charAt(i) == cryptogram.charAt(i - 1)) continue;
            if (i + 1 < cryptogram.length() && cryptogram.charAt(i) == cryptogram.charAt(i + 1)) continue;
            result = result + cryptogram.charAt(i);
        }

        return result;
    }

    public static String solution(String cryptogram) {
        while (true) {
            if (!areThereDuplicateCharacters(cryptogram)) break;

            cryptogram = deleteDuplicateCharacters(cryptogram);
        }

        String answer = cryptogram;
        return answer;
    }
}
