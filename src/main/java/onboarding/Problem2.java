package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = new String();

        // 스택을 활용해 중복 문자를 제거
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == cryptogram.charAt(i)) stack.pop();
            else stack.push(cryptogram.charAt(i));
        }

        // 정답 문자열 저장
        Stack<Character> getAns = new Stack<>();
        while (!stack.isEmpty()) {
            getAns.push(stack.peek());
            stack.pop();
        }

        while (!getAns.isEmpty()) {
            answer = answer + getAns.peek();
            getAns.pop();
        }

        return answer;
    }
}
