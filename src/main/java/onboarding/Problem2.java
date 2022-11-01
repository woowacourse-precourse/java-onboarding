package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Deque<String> deque = new ArrayDeque<>();
        for(String c: cryptogram.split("")) {
            if(!deque.isEmpty() && deque.peekFirst().equals(c)) deque.removeFirst();
            else deque.addFirst(c);
        }
        while(!deque.isEmpty()) {
            answer += deque.pollLast();
        }
        return answer;
    }
}
