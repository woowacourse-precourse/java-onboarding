package onboarding;

import java.util.Stack;

/*
 * 1. removeDuplication(): 정규표현식을 반복해서 사용해 중복된 문자를 제거하고 문자열을 반환하는 메서드
 *   1-1. 중복된 문자를 재귀적으로 제거
 */

public class Problem2 {
    private static int index = 0;
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        while (index < cryptogram.length()) {
            if (isOverlap(cryptogram, stack)) {
                removeOverlap(cryptogram, stack);
                continue;
            }
            stack.push(cryptogram.charAt(index++));
        }

        return stackToString(stack);
    }

    private static boolean isOverlap(String cryptogram, Stack<Character> stack) {
        return !stack.isEmpty() && index < cryptogram.length() && stack.peek().equals(cryptogram.charAt(index));
    }

    private static void removeOverlap(String cryptogram, Stack<Character> stack) {
        while (isOverlap(cryptogram, stack)) {
            index++;
        }
        stack.pop();
    }

    private static String stackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();

        stack.forEach(sb::append);

        return sb.toString();
    }
}
