package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {

    public static String solution(String cryptogram) {
        Deque<Character> deque = new ArrayDeque<>();
        return removeDuplicate(cryptogram,deque);

    }

    private static String removeDuplicate(String cryptogram, Deque<Character> deque) {
        boolean changeFlag = false;
        char before = '@';
        for (int i = 0; i < cryptogram.length(); i++) {
            if (deque.isEmpty()) {
                deque.offerLast(cryptogram.charAt(i));
                before = cryptogram.charAt(i);
            } else if (before != cryptogram.charAt(i) && deque.peekLast() != cryptogram.charAt(i)) {
                deque.offerLast(cryptogram.charAt(i));
                before = cryptogram.charAt(i);
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

    private static String getString(Deque<Character> letters) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!letters.isEmpty()) {
            stringBuilder.append(letters.pollFirst());
        }
        return String.valueOf(stringBuilder);
    }

}
