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
            deleteDuplicatedWords(eachWords, answer);

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

    private static void deleteDuplicatedWords(Queue<Character> eachWords, StringBuilder answer) {
        while (!eachWords.isEmpty()) {
            char word = eachWords.poll();
            answer.append(word);
        }
    }

    private static boolean hasDuplicatedWords(Queue<Character> eachWords, char word) {
        boolean duplicated = false;

        while (!eachWords.isEmpty()) {
            char targetWord = eachWords.peek();

            if (word == targetWord) {
                eachWords.poll();
                duplicated = true;
            } else {
                break;
            }
        }

        return duplicated;
    }
}
