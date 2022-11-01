package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public static String solution(String cryptogram) {
        Deque<Character> deque = new ArrayDeque<Character>();
        String answer = new String();
        int len = cryptogram.length();

        deque.addLast(cryptogram.charAt(0));
        for(int index = 1; index < len;index++) {
            if ( !deque.isEmpty() && (deque.peekLast() == cryptogram.charAt(index)))
                deque.pollLast();
            else
                deque.addLast(cryptogram.charAt(index));
        }

        while(!deque.isEmpty()){
            answer += Character.toString(deque.peekFirst());
            deque.pollFirst();
        }
        return answer;
    }
}
