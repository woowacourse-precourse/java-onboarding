package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {

    private static int increaseIdxWhenCharEqual(Character decryptionLastChar, String cryptogram, int idx) {

        while (decryptionLastChar == cryptogram.charAt(idx)) {
            idx++;
        }

        return idx;
    }

    private static void deleteOrAppendDecryption(Deque<Character> decryptionCharStack, String cryptogram, int idx, int newIdx) {

        if (idx != newIdx) {
            deleteLastDecryptionChar(decryptionCharStack);
            return;
        }

        appendDecryptionChar(decryptionCharStack, cryptogram, newIdx);
    }

    private static void deleteLastDecryptionChar(Deque<Character> decryptionCharStack) {
        decryptionCharStack.getLast();
    }

    private static void appendDecryptionChar(Deque<Character> decryptionCharStack, String cryptogram, int newIdx) {
        if (newIdx < cryptogram.length()) {
            decryptionCharStack.addLast(cryptogram.charAt(newIdx));
        }
    }

    /**
     * 임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
     *
     * @param cryptogram 임의의 암호문 문자열
     * @return 해독한 문자열
     */
    public static String solution(String cryptogram) {
        Deque<Character> decryptionCharStack = new ArrayDeque<>();
        int idx = 0;

        while (idx < cryptogram.length()) {
            int newIdx = increaseIdxWhenCharEqual(decryptionCharStack.peekLast(), cryptogram, idx);
            deleteOrAppendDecryption(decryptionCharStack, cryptogram, idx, newIdx);
            idx = newIdx + 1;
        }

        return decryptionCharStackToString(decryptionCharStack);
    }
}
