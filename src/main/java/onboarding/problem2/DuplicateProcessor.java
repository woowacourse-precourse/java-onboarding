package onboarding.problem2;

import java.util.ArrayDeque;
import java.util.Deque;

public class DuplicateProcessor {

    private final Deque<Character> stack = new ArrayDeque<>();
    private boolean flag = true;

    public char[] checkDuplication(char[] cryptoCharArr) {
        int duplicationCount = 0;

        for (char cryptoChar : cryptoCharArr) {
            if (stack.isEmpty()) {
                stack.push(cryptoChar);
                continue;
            }

            if (stack.peek() == cryptoChar) {
                stack.pop();
                duplicationCount++;
                continue;
            }

            stack.push(cryptoChar);
        }

        return getDecryptedCharArray(stack, cryptoCharArr, duplicationCount);
    }

    private char[] getDecryptedCharArray(Deque<Character> stack, char[] cryptoCharArr,
                                         int duplicationCount) {
        if (duplicationCount == 0) {
            flag = false;
            return cryptoCharArr;
        }

        int size = stack.size();
        char[] result = new char[size];

        for (int i = 0; i < size; i++) {
            if (stack.isEmpty()) {
                break;
            }

            result[i] = stack.poll();
        }

        return result;
    }
}
