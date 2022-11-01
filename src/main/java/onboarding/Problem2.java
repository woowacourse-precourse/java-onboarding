package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        /* 스택 생성 */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            if (stack.size() == 0) {
                stack.push(cryptogram.charAt(i));   // 첫 값 삽입
            } else {
                if (stack.peek().equals(cryptogram.charAt(i))) {
                    stack.pop();    // 중복 제거
                } else {
                    stack.push(cryptogram.charAt(i));   // 값 삽입
                }
            }
        }

        // 문자열로 반환
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        return answer;
    }
}


