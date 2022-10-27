package onboarding;

import java.util.*;

/**
 * 기능 목록
 * 1. 중복 문자 삭제
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>();
        String[] strings = cryptogram.split("");

        for (String string : strings) {
            if (!stack.isEmpty() && stack.peek().equals(string)) {
                stack.pop();
            } else {
                stack.add(string);
            }
        }

        return stack.stream().reduce("", (x, y) -> x + y);
    }
}
