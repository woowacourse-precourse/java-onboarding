package onboarding;

import java.util.Stack;

/** 기능 목록
 * solutionLogic : 메인 솔루션
 * stackToString : Stack을 String으로 변환
 * checkValid : 에러 처리
 * checkLength : 문자열 길이 유효성 검사
 * checkLowerCase : 문자열 내 소문자 유효성 검사
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        final String errorCase ="-1";
        if (!checkValid(cryptogram)) {
            return errorCase;
        }
        return stackToString(solutionLogic(cryptogram));
    }

    public static Stack<Character> solutionLogic(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.add(c);
            } else if (stack.peek() == c) {
                stack.pop();
            }
        }
        return stack;
    }

    public static String stackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    public static boolean checkValid(String s) {
        return checkLength(s) && checkLowerCase(s);
    }

    public static boolean checkLength(String s) {
        int len = s.length();
        return 1 <= len && len <= 1000;
    }

    public static boolean checkLowerCase(String s) {
        return s.equals(s.toLowerCase());
    }

}
