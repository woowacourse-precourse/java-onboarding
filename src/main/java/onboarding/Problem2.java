package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    private static final String OUTPUT_IS_BLANK = "";
    private static final char INIT_LAST_REMOVE = ' ';

    public static String solution(String cryptogram) {
        return isNonDuplicateLength(cryptogram) ? cryptogram : removeAdjacentDuplicate(cryptogram.toCharArray());
    }

    private static boolean isNonDuplicateLength(String str) {
        return str.length() == 1;
    }

    private static String removeAdjacentDuplicate(char[] cryptogramArray) {
        Deque<Character> charDeque = new ArrayDeque<>();
        char lastRemove = initLastRemove(INIT_LAST_REMOVE);

        for (char digit : cryptogramArray) {
            lastRemove = getNewWord(charDeque, digit, lastRemove);
        }

        return charDeque.isEmpty() ? OUTPUT_IS_BLANK : getCharDequeToString(charDeque);
    }

    private static char getNewWord(Deque<Character> charDeque, char digit, char lastRemove) {
        if (charDeque.isEmpty()) {
            charDeque.add(digit);
            return lastRemove;
        }

        if (isSameCompareElement(digit, lastRemove)) {
            return lastRemove;
        }

        char prevElement = charDeque.getLast();
        if (isSameCompareElement(digit, prevElement)) {
            charDeque.removeLast();
            return initLastRemove(prevElement);
        }

        charDeque.add(digit);
        return initLastRemove(INIT_LAST_REMOVE);
    }

    private static String getCharDequeToString(Deque<Character> charDeque) {
        StringBuilder sb = new StringBuilder();
        charDeque.forEach(sb::append);
        return sb.toString();
    }

    private static boolean isSameCompareElement(char currentElement, char compareElement) {
        return currentElement == compareElement;
    }

    private static char initLastRemove(char lastRemove) {
        return lastRemove;
    }
}
