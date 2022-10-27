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
        String answer = "answer";


        return answer;
    }

    public static Stack<Character> solutionLogic(char[] charArray) {
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

    public static boolean checkValid(String s) {
        return checkLength(s) && checkLowerCase(s);
    }

    public static boolean checkLength(String s) {
        int len = s.length();
        if (1 <= len && len <= 1000) {
            return true;
        }
        return false;
    }

    public static boolean checkLowerCase(String s) {
        if (s.equals(s.toLowerCase())) {
            return true;
        }
        return false;
    }

}
