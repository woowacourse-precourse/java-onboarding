package onboarding;

import java.util.Deque;
import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        Deque<Character> deque = new LinkedList<>();

        for (char ele : cryptogram.toCharArray()) {
            if (!isDequeEmpty(deque)) {
                
            }
        }

        return answer;
    }

    public static boolean isDequeEmpty(Deque<Character> deque) {
        return deque.isEmpty();
    }
}
