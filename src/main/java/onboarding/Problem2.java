package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;

public class Problem2 {

    static final int START_RANGE = 1;
    static final int END_RANGE = 1_000;

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


    private static StringBuffer dequeToStr(Deque<Character> deque) {
        StringBuffer stringBuffer = new StringBuffer();

        while (!deque.isEmpty()) {
            stringBuffer.append(deque.getFirst());
            deque.removeFirst();
        }
        return stringBuffer;
    }

    public static String solution(String cryptogram) {
        if (!isValidLength(cryptogram)) {
            throw new InputMismatchException("입력된 문자열의 크기가 [1,1000] 이내가 아닙니다.");
        }

        return dequeToStr(removeDuplicates(cryptogram)).toString();
    }

    private static boolean isValidLength(String cryptogram) {
        return START_RANGE <= cryptogram.length() && cryptogram.length() <= END_RANGE;
    }
}
