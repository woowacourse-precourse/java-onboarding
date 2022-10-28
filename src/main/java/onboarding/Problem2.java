package onboarding;

import java.util.*;

/**
 * 기능 목록
 * 1. 중복 문자 삭제
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        final String[] strings = cryptogram.split("");

        return deleteDuplication(strings).stream()
                .reduce("", (x, y) -> x + y);
    }

    /**
     * 문자 배열의 중복 문자 삭제
     *
     * @param strings
     * @return 삭제 후 스택 배열
     */
    private static Stack<String> deleteDuplication(String[] strings) {
        Stack<String> stack = new Stack<>();

        for (String string : strings) {
            if (!stack.isEmpty() && stack.peek().equals(string)) {
                stack.pop();
            } else {
                stack.add(string);
            }
        }

        return stack;
    }
}
