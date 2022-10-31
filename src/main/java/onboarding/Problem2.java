package onboarding;

import java.util.Stack;

/** 기능 목록
 * solutionLogic    : 메인 솔루션
 * eraseIfSame      : 같은 문자들을 지워줌
 * stackToString    : Stack을 String으로 변환
 * checkValid       : 에러 처리
 * checkLength      : 문자열 길이 유효성 검사
 * checkLowerCase   : 문자열 내 소문자 유효성 검사
 */

public class Problem2 {

    public static String solution(String cryptogram) {
        if (!checkValid(cryptogram)) {
            throw new IllegalArgumentException("입력된 형식이 잘못됨");
        }
        return stackToString(solutionLogic(cryptogram));
    }

    private static Stack<Character> solutionLogic(String s) {
        char[] charArray = s.toCharArray();
        boolean needPop = false;
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (!stack.isEmpty() && stack.peek() != c) {
                eraseIfSame(stack);
            }
            stack.add(c);
        }
        eraseIfSame(stack);
        return stack;
    }

    private static void eraseIfSame(Stack<Character> stack) {
        char compare = stack.pop();
        boolean isDeleted = false;
        while (!stack.isEmpty() && stack.peek() == compare) {
            isDeleted = true;
            stack.pop();
        }
        if (!isDeleted) {
            stack.add(compare);
        }
    }

    private static String stackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    private static boolean checkValid(String s) {
        return checkLength(s) && checkLowerCase(s);
    }

    private static boolean checkLength(String s) {
        int len = s.length();
        return 1 <= len && len <= 1000;
    }

    private static boolean checkLowerCase(String s) {
        return s.equals(s.toLowerCase());
    }
}
