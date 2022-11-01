package onboarding;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (isDuplicated(cryptogram)) {
            Queue<Character> eachWords = new ArrayDeque<>();

            for (int i = 0; i < cryptogram.length(); i++) {
                eachWords.offer(cryptogram.charAt(i));
            }

            StringBuilder answer = new StringBuilder();

            cryptogram = answer.toString();
        }

        return cryptogram;
    }

    private static boolean isDuplicated(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

}
