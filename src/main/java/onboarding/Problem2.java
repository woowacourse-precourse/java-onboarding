package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
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
