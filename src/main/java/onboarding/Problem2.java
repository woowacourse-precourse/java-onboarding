package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        // 암호문에서 중복되는 문자가 없도록 삭제한다.
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

        return answer;
    }

}
