package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public static String solution(String cryptogram) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char character: cryptogram.toCharArray()) {
            if (!deque.isEmpty() && deque.peekLast() != character) {
                removeDuplicateLetters(deque);
            }
            deque.addLast(character);
        }
        removeDuplicateLetters(deque);

        StringBuilder answer = new StringBuilder();
        while (!deque.isEmpty()) {
            answer.append(deque.pollFirst());
        }
        return answer.toString();
    }

    private static void removeDuplicateLetters(Deque<Character> deque) {
        while (!deque.isEmpty()) {
            char temp = deque.peekLast();
            if (deque.pollLast() != deque.peekLast()) {
                deque.addLast(temp);
                break;
            }
            while (!deque.isEmpty() && temp == deque.peekLast()) {
                deque.pollLast();
            }
        }
    }
}
