package onboarding;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /**
     * 입력 받은 String을 deque에 뒤에서부터 한 문자씩 저장하며 연속된 중복값을 제거한다.
     * @param cryptogram
     */
    public static Deque<Character> decoding(String cryptogram) {
        Deque<Character> deque = new LinkedList<>();
        deque.addFirst(cryptogram.charAt(0));

        for (int i = 1; i < cryptogram.length(); i++) {
            if(!deque.isEmpty() && deque.peekLast() == cryptogram.charAt(i)) {
                while(!deque.isEmpty() && deque.peekLast() == cryptogram.charAt(i)) {
                    deque.pollLast();
                }
            }
            else deque.addLast(cryptogram.charAt(i));
        }

        return deque;
    }

}
