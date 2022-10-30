package onboarding;

import java.util.Stack;

public class Problem2 {
    private static Stack<Character> words = new Stack<>();
    private static Boolean wasTopDuplicate;
    public static String solution(String cryptogram) {
        words.clear();
        wasTopDuplicate = false;
        deleteDuplicateWordsInRow(cryptogram);
        String answer = toString(words);
        return answer;
    }


    public static void deleteDuplicateWordsInRow(String cryptogram) {
        words.push(cryptogram.charAt(0)); //첫 문자는 바로 push

        for (int i = 1; i < cryptogram.length(); i++) {
            char nowChar = cryptogram.charAt(i);
            char top = words.peek();

            checkNewCharDuplicate(nowChar, top);
        }

        checkLastStackTop();
        return;
    }

    private static void checkNewCharDuplicate(char nowChar, char top) {
        if (isNowCharTopSame(nowChar, top)) {
            wasTopDuplicate = true;
            return;
        }
        updateStack(nowChar);
    }

    private static Boolean isNowCharTopSame(char nowChar, char top) {
        if (nowChar == top) {
            return true;
        }
        return false;
    }

    private static void updateStack(char nowChar) {
        if (wasTopDuplicate) {
            changeStackTop(nowChar);
        }
        putNewCharToStack(nowChar);
    }

    private static void checkLastStackTop() {
        if (wasTopDuplicate) {
            words.pop();
        }
    }

    private static void changeStackTop(char nowChar) {
        words.pop();

        if (words.isEmpty()) {
            wasTopDuplicate = false;
            return;
        }
        char newTop = words.peek();
        if (isNowCharTopSame(nowChar, newTop)) {
            wasTopDuplicate = true;
            return;
        }
        wasTopDuplicate = false;
    }

    private static void putNewCharToStack(char nowChar) {
        if (wasTopDuplicate) {
            return;
        }
        words.push(nowChar);
    }

    private static String toString(Stack<Character> words) {
        StringBuilder sb = new StringBuilder();
        while (!words.isEmpty()) {
            sb.insert(0, words.pop());
        }
        return sb.toString();
    }
}
