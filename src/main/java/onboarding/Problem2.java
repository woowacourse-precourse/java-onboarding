package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        LinkedList<Character> deduplicationLetters = new LinkedList<>();
        char[] cryptogramCharArray = cryptogram.toCharArray();

        for (char letter : cryptogramCharArray) {
            if (isEmpty(deduplicationLetters)) {
                addLetter(deduplicationLetters,letter);
                continue;
            }
            if (isDuplicated(deduplicationLetters, letter)) {
                removeDuplication(deduplicationLetters);
                continue;
            }
            //not empty & not duplicated
            addLetter(deduplicationLetters,letter);
        }

        String answer = getDeduplication(deduplicationLetters);
        return answer;
    }

    private static boolean isEmpty(LinkedList<Character> deduplicationLetters) {
        return deduplicationLetters.isEmpty();
    }

    private static void addLetter(LinkedList<Character> deduplicationLetters,char letter) {
        deduplicationLetters.add(letter);
    }

    private static boolean isDuplicated(LinkedList<Character> deduplicationLetters, char letter) {
        return deduplicationLetters.getLast().equals(letter);
    }

    private static void removeDuplication(LinkedList<Character> deduplicationLetters) {
        deduplicationLetters.removeLast();
    }

    private static String getDeduplication(LinkedList<Character> deduplicationLetters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter : deduplicationLetters) {
            stringBuilder.append(letter);
        }

        return stringBuilder.toString();
    }
}
