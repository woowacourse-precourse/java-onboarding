package onboarding;

import java.util.Stack;

public class Problem2 {
    private static Stack<Character> stack = new Stack<>();
    static boolean flag = false;
    public static String solution(String cryptogram) {
        String answer = "answer";
        // 1. 문자열을 훑으면서 문자를 stack에 push
        // 2. 연속 문자가 제거된 채 쌓인 문자들을 뒤집어서 반환
        return answer;
    }

    // 문자의 push 여부를 결정하는 함수 pushOrNot()
    private static void pushOrNot(char c) {
        // 스택이 비어있다면 문자를 push
        if(stack.isEmpty()){
            stack.push(c);
        // 스택이 비어있지 않은 상황
        // top의 문자와 이번에 넣으려는 문자가 같다면 flag를 true로 변경
        } else if (stack.peek() == c) {
            flag = true;
        // top의 문자와 이번에 넣으려는 문자가 다르다면 flag를 확인하여 연속 문자 제거 후 push
        } else {
            if(flag) stack.pop();
            flag = false;
            stack.push(c);
        }
    }
}
