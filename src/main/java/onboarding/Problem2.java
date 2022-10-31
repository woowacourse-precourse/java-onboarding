package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        LinkedList<Character> deduplicationLetters = new LinkedList<>();
        char[] cryptogramCharArray = cryptogram.toCharArray();

        for (char letter : cryptogramCharArray) {
            if (deduplicationLetters.isEmpty()) {
                deduplicationLetters.add(letter);
                continue;
            }
            if (isDuplicated(deduplicationLetters, letter)) {
                removeDuplication(deduplicationLetters);
                continue;
            }
            deduplicationLetters.add(letter);
        }

        return decrypt(deduplicationLetters);
    }

    private static boolean isDuplicated(LinkedList<Character> deduplicationLetters, char letter) {
        return deduplicationLetters.getLast().equals(letter);
    }

    private static void removeDuplication(LinkedList<Character> deduplicationLetters) {
        deduplicationLetters.removeLast();
    }

    private static String decrypt(LinkedList<Character> deduplicationLetters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter : deduplicationLetters) {
            stringBuilder.append(letter);
        }

        return stringBuilder.toString();
    }
}
