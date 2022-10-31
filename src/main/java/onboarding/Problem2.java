package onboarding;

import java.util.Stack;

public class Problem2 {
    /**
     * 암호문 해독
     * @param cryptogram
     * @return answer
     */
    public static String solution(String cryptogram) {
        String match = "[^a-z]"; // 알파벳 소문자가 아닌 정규식
        Stack<Character> stack = new Stack<>();
        //연속하는 두 문자 발생 시 스택에서 pop, 아닌 경우 스택에 push
        for(char c : cryptogram.toCharArray()) {
            if(!stack.empty() && stack.peek().equals(c)) stack.pop();
            else stack.push(c);
        }

        String answer = stack.toString().replaceAll(match,""); // 정규식 패턴에 해당하지 않는 모든 문자 제거
        return answer;
    }
}