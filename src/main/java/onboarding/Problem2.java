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


    private static StringBuffer dequeToStr(String cryptogram) {
        StringBuffer stringBuffer = new StringBuffer();
        Deque<Character> deque = removeDuplicates(cryptogram);

        while (!deque.isEmpty()) {
            stringBuffer.append(deque.getFirst());
            deque.removeFirst();
        }
        return stringBuffer;
    }

    public static String solution(String cryptogram) {
        String answer = "";

        StringBuffer stringBuffer = dequeToStr(cryptogram);

        answer = stringBuffer.toString();

        return answer;
    }
}
