package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {

    private static int increaseTail(Character decryptionLastChar, String cryptogram, int idx) {

        while (decryptionLastChar == cryptogram.charAt(idx)) {
            idx++;
        }

        return idx;
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
            int newIdx = increaseTail(decryptionCharStack.peekLast(), cryptogram, idx);
            checkSkipCharacter(decryptionCharStack, idx, newIdx);
            updateDeque(decryptionCharStack, cryptogram.charAt(newIdx));
            idx = newIdx + 1;
        }

        return decryptionCharStackToString(decryptionCharStack);
    }
}
