package onboarding;

import java.util.Stack;

public class Problem2 {

    // 스택에 문자열을 중복없이 추가하여 결과 리턴
    public static String getCryptogram(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<cryptogram.length(); i++) {
            char cur = cryptogram.charAt(i);

            if(stack.isEmpty()) {
                stack.push(cur);
                continue;
            }


            stack.push(cur);
        }

        return sb.toString();
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
