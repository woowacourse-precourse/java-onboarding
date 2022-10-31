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

            // 중복 체크, 중복 시 삭제 실행 및 추가 작업 패스
            if(stack.peek() == cur) {
                stack.pop();
                continue;
            }

            stack.push(cur);
        }

        // 소문자 이외 제외 후 리턴
        while(!stack.isEmpty()) {
            char cur = stack.pop();
            if( cur <'a' || cur >'z') continue;
            sb.append(cur);
        }

        sb = sb.reverse();
        return sb.toString();
    }
    public static String solution(String cryptogram) {
        String answer = getCryptogram(cryptogram);

        return answer;
    }
}
