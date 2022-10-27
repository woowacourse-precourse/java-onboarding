package onboarding;

import java.util.Stack;

public class Problem2 {
    /**
     문제 :
     - 연속된 중복 문자를 삭제한 결과를 리턴

     해결 방법 :
     - 스택 이용
     - 빈 스택이면 푸쉬
     - peak 했을 때 같으면 pop
     - 같지 않으면 푸쉬

     **/
    public static String solution(String cryptogram) {
        String answer = "answer";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            if(stack.isEmpty()) stack.push(cryptogram.charAt(i));
            if (stack.peek().equals(cryptogram.charAt(i))) {
                stack.pop();
            } else stack.push(cryptogram.charAt(i));
        }

        for (int i = 0; i < stack.size(); i++) {
            answer += stack.pop();
        }

        return answer;
    }
}
