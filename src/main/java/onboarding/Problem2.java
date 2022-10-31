package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    public static String solution(String cryptogram) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            deque.addLast(cryptogram.charAt(i));
        }

        //중복 문자열 삭제하기
        deque = deleteOverlappedChar(deque);

        //결과 리턴
        return getString(deque);

    }

    private static String getString(Deque<Character> deque) {
        if (deque.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : deque) {
            sb.append(character);
        }
        return sb.toString();
    }

    private static Deque<Character> deleteOverlappedChar(Deque<Character> deque) {
        int pre;
        do {
            pre = deque.size();
            if (pre == 0) {
                break;
            }
            Deque<Character> dq2 = new ArrayDeque<>();
            dq2.addLast(deque.pollFirst());
            while (!deque.isEmpty()) {
                if (dq2.peekLast() == deque.peekFirst()) {
                    while (dq2.peekLast() == deque.peekFirst()) {
                        deque.pollFirst();
                    }
                    dq2.pollLast();
                }
                if(dq2.peekLast() != deque.peekFirst()) {
                    dq2.addLast(deque.pollFirst());
                }
            }
            deque = dq2;
        } while (pre != deque.size());

        return deque;
    }
}
