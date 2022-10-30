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
            Character nowChar = getNewChar(i, cryptogram);
            char top = words.peek();

            Boolean isNewCharDuplicate = checkNewCharDuplicate(nowChar, top);
            if (isNewCharDuplicate) {
                continue;
            }

            Character nextChar = getNewChar(i + 1, cryptogram);
            updateStack(nowChar, nextChar);
        }

        checkLastStackTop();
        return;
    }

    private static Boolean checkNewCharDuplicate(char nowChar, char top) {
        if (isNowCharTopSame(nowChar, top)) {
            wasTopDuplicate = true;
            return true;
        }
        return false;
    }

    private static Character getNewChar(int idx, String cryptogram) {
        if (idx < cryptogram.length()) {
            return cryptogram.charAt(idx);
        }
        return null;
    }

    private static Boolean isNowCharTopSame(char nowChar, char top) {
        if (nowChar == top) {
            return true;
        }
        return false;
    }

    private static void updateStack(char nowChar, Character nextChar) {
        if (wasTopDuplicate) {
            changeStackTop(nowChar, nextChar);
        }
        putNewCharToStack(nowChar);
    }

    private static void checkLastStackTop() {
        if (wasTopDuplicate) {
            words.pop();
        }
    }

    private static void changeStackTop(char nowChar, Character nextChar) {
        words.pop();

        if (words.isEmpty()) {
            wasTopDuplicate = false;
            return;
        }

        if(nextChar != null && nowChar == nextChar) {
            wasTopDuplicate = false;
            return;
        }

        //이 전에 새 char 와 다음 char 가 연속되는지 체크 -> 연속되면 newTop 이랑 비교 안하고 그냥 push 함
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
