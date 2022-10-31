package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {

    public static String solution(String cryptogram) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char curChar : cryptogram.toCharArray()) {
            if (!deque.isEmpty() && deque.peekLast() == curChar) {
                deque.pollLast();
                continue;
            }
            deque.offerLast(curChar);
        }

        StringBuilder answer = new StringBuilder();
        while (!deque.isEmpty()) {
            answer.append(deque.poll());
        }

        return answer.toString();
    }
}
