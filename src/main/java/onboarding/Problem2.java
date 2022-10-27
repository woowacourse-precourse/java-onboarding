package onboarding;

import java.util.*;

/**
 * [풀이방법]
 * queue 에 넣으면서 확인하고 같으면 poll, 다르면 offer
 * -> 수정 -> 같은 단어가 2번이상 반복될 때 예외 발생
 * 같은 단어가 2번이상 반복될 때 그 단어를 저장해두고 한번에 지워버리는 방식으로 코드 구성
 **/
public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder();

        /**
         z y e l l l e y z
         **/
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
            sb.append(queue.pollFirst());
        }

        return sb.toString();
    }
}
