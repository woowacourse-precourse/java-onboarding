package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    private static final String OUTPUT_IS_BLANK = "";

    public static String solution(String cryptogram) {
        return isValidStringLength(cryptogram) ? cryptogram : removeAdjacentDuplicate(getStringToChar(cryptogram));
    }

    private static boolean isValidStringLength(String str) {
        return str.length() == 1;
    }

    private static String removeAdjacentDuplicate(char[] cryptogramArray) {
        Deque<Character> charDeque = new ArrayDeque<>();
        char lastRemove = initLastRemove();

        for (int i = 0; i < cryptogramArray.length; i++) {
            if (isEmptyDeque(charDeque, i)) {
                addElementToDeque(charDeque, cryptogramArray[i]);
                continue;
            }

            char lastElement = charDeque.getLast();
            if (isSameLastRemove(cryptogramArray[i], lastRemove)) {
                continue;
            }

            if (isSamePrevElement(cryptogramArray[i], lastElement, charDeque)) {
                lastRemove = initLastRemove(lastElement);
                continue;
            }
            lastRemove = initLastRemove();
            addElementToDeque(charDeque, cryptogramArray[i]);
        }

        if (isOutputBlank(charDeque)) {
            return OUTPUT_IS_BLANK;
        }

        return getCharDequeToString(charDeque);
    }

    private static char[] getStringToChar(String str) {
        return str.toCharArray();
    }

    private static String getCharDequeToString(Deque<Character> charDeque) {
        StringBuilder sb = new StringBuilder();
        for (char dequeueElement : charDeque) {
            sb.append(dequeueElement);
        }
        return sb.toString();
    }

    private static boolean isOutputBlank(Deque<Character> deque) {
        return deque.isEmpty();
    }

    private static boolean isEmptyDeque(Deque<Character> deque, int dequeIndex) {
        return dequeIndex == 0 || deque.isEmpty();
    }

    private static void addElementToDeque(Deque<Character> deque, char element) {
        deque.add(element);
    }

    private static boolean isSameLastRemove(char currentElement, char lastRemove) {
        return currentElement == lastRemove;
    }

    private static boolean isSamePrevElement(char currentElement, char prevElement, Deque<Character> deque) {
        if (currentElement == prevElement) {
            removeDuplicate(deque);
            return true;
        }
        return false;
    }

    private static void removeDuplicate(Deque<Character> deque) {
        deque.removeLast();
    }

    private static char initLastRemove() {
        return ' ';
    }

    private static char initLastRemove(char lastElement) {
        return lastElement;
    }
}
