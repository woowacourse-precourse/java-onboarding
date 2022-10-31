package onboarding;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem2 {
    public static String solution(String cryptogram) {

        while (hasDuplicated(cryptogram)) {
            Queue<Character> characterQueue = new ArrayDeque<>();

            for (int i = 0; i < cryptogram.length(); i++) {
                characterQueue.offer(cryptogram.charAt(i));
            }

            StringBuilder stringBuilder = new StringBuilder();

            while (!characterQueue.isEmpty()) {

                char standardChar = characterQueue.poll();

                boolean duplicated = deleteDuplicatedLetter(characterQueue, standardChar);

                if (!duplicated) {
                    stringBuilder.append(standardChar);
                }
            }

            cryptogram = stringBuilder.toString();

        }

        return cryptogram;
    }

    private static boolean deleteDuplicatedLetter(Queue<Character> characterQueue, char standardChar) {
        boolean duplicated = false;

        while (!characterQueue.isEmpty()) {
            char targetChar = characterQueue.peek();

            if (standardChar == targetChar) {
                characterQueue.poll();
                duplicated = true;
            } else {
                break;
            }
        }

        return duplicated;
    }

    private static boolean hasDuplicated(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}
