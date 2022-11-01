package onboarding;

import java.util.Stack;

public class Problem2 {
    private static Stack<Character> stack = new Stack<>();
    static boolean flag = false;

    public static String solution(String cryptogram) {
        String answer = "answer";
        for (int i = 0; i < cryptogram.length(); i++) {
            pushOrNot(cryptogram.charAt(i));
        }
        if (flag) stack.pop();

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        answer = sb.reverse().toString();
        return answer;
    }

    // 문자의 push 여부를 결정하는 함수 pushOrNot()
    private static void pushOrNot(char c) {
        if (stack.isEmpty()) {
            stack.push(c);
            return;
        }
        if (flag) {
            stack.pop();
            flag = false;
        }
        if (stack.peek() == c) {
            flag = true;
        }
        stack.push(c);
    }
}
