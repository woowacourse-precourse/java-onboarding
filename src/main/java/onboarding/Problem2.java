package onboarding;

import java.util.*;

/**
 * [풀이방법]
 * queue 에 넣으면서 확인하고 같으면 poll, 다르면 offer
 **/
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        Deque<Character> queue = new ArrayDeque<>();

        queue.offer(cryptogram.charAt(0));
        for (int i = 1; i < cryptogram.length(); i++) {
            if (queue.peekLast() == cryptogram.charAt(i)) {
                queue.pollLast();
            } else {
                queue.offerLast(cryptogram.charAt(i));
            }
        }

        while (!queue.isEmpty()) {
            answer += queue.pollFirst();
        }

        return answer;
    }
}
