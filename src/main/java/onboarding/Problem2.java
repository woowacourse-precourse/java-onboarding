package onboarding;

import java.util.Stack;

public class Problem2 {
    private static Stack<Character> stack = new Stack<>();
    static boolean flag = false;

    public static String solution(String cryptogram) {
        String answer = "answer";
        // 1. 문자열을 훑으면서 문자를 stack에 push
        for (int i=0; i<cryptogram.length(); i++){
            pushOrNot(cryptogram.charAt(i));
        }
        if(flag) stack.pop();

        StringBuffer sb = new StringBuffer();
        // 2. 연속 문자가 제거된 채 쌓인 문자들을 뒤집어서 반환
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        answer = sb.reverse().toString();
        return answer;
    }

    // 문자의 push 여부를 결정하는 함수 pushOrNot()
    private static void pushOrNot(char c) {
        // 스택이 비어있다면 문자를 push
        if(stack.isEmpty()){
            stack.push(c);
        // 스택이 비어있지 않은 상황
        } else {
            // top의 문자가 연속 문자의 일부였다면 pop
            if(flag) {
                stack.pop();
                flag = false;
            }
            // top의 문자가 넣으려는 문자와 같다면 flag를 true로 변경하고, 같지 않다면 문자를 push
            if(stack.peek()==c) {
                flag = true;
            } else {
                stack.push(c);
            }
        }
    }
}
