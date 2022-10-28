package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    private static Deque<Character> deque = new ArrayDeque<>();

    public static String solution(String cryptogram) {
        deque.clear();
        return removeDuplicate(cryptogram);

    }

    private static String removeDuplicate(String cryptogram) {
        boolean changeFlag = false;
        char before = '@';
        for (int i = 0; i < cryptogram.length(); i++) {
            if (deque.isEmpty()) {
                deque.offerLast(cryptogram.charAt(i));
                before = cryptogram.charAt(i);
            } else if (before != cryptogram.charAt(i) && deque.peekLast() != cryptogram.charAt(i)) {
                deque.offerLast(cryptogram.charAt(i));
                before=cryptogram.charAt(i);
                changeFlag = false;
            } else if (before == cryptogram.charAt(i) && !changeFlag) {
                changeFlag = true;
                deque.removeLast();
            } else if (deque.peekLast() == cryptogram.charAt(i)) {
                before = cryptogram.charAt(i);
                deque.removeLast();
            }
        }
        return getString(deque);
    }

    private static String getString(Deque<Character> deque) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!Problem2.deque.isEmpty()) {
            stringBuilder.append(Problem2.deque.pollFirst());
        }
        return String.valueOf(stringBuilder);
    }

}
