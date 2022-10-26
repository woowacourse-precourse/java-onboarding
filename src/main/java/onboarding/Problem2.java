/*
[기능 목록]
1. 암호 해독
 */

package onboarding;

import java.util.Deque;
import java.util.ArrayDeque;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String decrypt(String cryptogram) {
        char[] cryptogramCharArray = cryptogram.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : cryptogramCharArray) {
            if (!stack.isEmpty() && stack.peekLast() == c) {
                stack.pollLast();
                continue;
            }
            stack.add(c);
        }

        return stackToString(stack);
    }

    private static String stackToString(Deque<Character> stack) {
        int decryptedLength = stack.size();
        char[] decryptedCharArray = new char[decryptedLength];

        int index = 0;
        while (!stack.isEmpty()) {
            decryptedCharArray[index++] = stack.poll();
        }

        return String.valueOf(decryptedCharArray);
    }
}
