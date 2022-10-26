package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public static String solution(String cryptogram) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!deque.isEmpty() && deque.peekLast() != cryptogram.charAt(i)) {
                // TODO: 덱에서 앞의 중복 문자열 지우기
            }
            deque.addLast(cryptogram.charAt(i));
        }
        // TODO: 마지막 문자 한번 더 처리

        StringBuilder answer = new StringBuilder();
        while (!deque.isEmpty()) {
            answer.append(deque.pollFirst());
        }
        return answer.toString();

    }
}
