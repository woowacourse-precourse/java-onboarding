package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;

public class Problem2 {

    private static Deque<Character> removeDuplicates(String cryptogram) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : cryptogram.toCharArray()) {
            enrichDeque(deque, ch);
        }
        return deque;
    }

    private static void enrichDeque(Deque<Character> deque, char ch) {
        if (!Character.isLowerCase(ch)) {
            throw new InputMismatchException("영문자 소문자가 아닌 입력이 들어왔습니다.");
        }

        if (isDuplicates(deque, ch)) {
            deque.removeLast();
            return;
        }

        deque.addLast(ch);
    }

    private static boolean isDuplicates(Deque<Character> deque, char ch) {
        return !deque.isEmpty() && deque.getLast() == ch;
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
