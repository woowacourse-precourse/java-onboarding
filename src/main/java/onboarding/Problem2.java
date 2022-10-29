package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {

    private static Deque<Character> removeDuplicates(String cryptogram) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : cryptogram.toCharArray()) {

            if (!deque.isEmpty() && deque.getLast() == ch) {
                deque.removeLast();
                continue;
            }

            deque.addLast(ch);
        }
        return deque;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
