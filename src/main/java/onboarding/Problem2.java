package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        Stack<Character> stack = new Stack<>();

        // 암호문에서 중복되는 문자열이 없도록 삭제한다.
        for (char c : cryptogram.toCharArray()) {
            if(!stack.isEmpty()) {
                char prev = stack.peek();
                if(prev == c) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }

        // 연속하는 중복 문자를 삭제한 결과를 return
        return stackToString(stack);
    }

    /**
     * Character 제네릭 타입의 스택을 문자열로 바꿔주는 함수
     * @param stack
     * @return {String}
     */
    public static String stackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
