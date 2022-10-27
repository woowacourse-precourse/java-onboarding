package onboarding;

import java.util.Stack;

/** 기능 목록
 * solutionLogic : 메인 솔루정
 * method 2 : 에러 처리
 * method 3 : 문자열 길이 유효성 검사
 * method 4 : 문자열 내 소문자 유효성 검사
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

}
