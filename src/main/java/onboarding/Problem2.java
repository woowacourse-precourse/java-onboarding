package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String match = "[^a-z]"; // 알파벳 소문자가 아닌 정규식
        //연속하는 두 문자 발생 시 스택에서 제거
        Stack<Character> stack = new Stack<>();
        for(char c : cryptogram.toCharArray()) {
            if(!stack.empty() && stack.peek().equals(c)) stack.pop();
            else stack.push(c);
        }

        String answer = stack.toString().replaceAll(match,"");
        return answer;
    }
}