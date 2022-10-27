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
}
