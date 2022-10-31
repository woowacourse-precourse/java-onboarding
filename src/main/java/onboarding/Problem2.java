package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 스택 자료구조를 이용한 기능(암호 해독)

        String answer = "";
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            // 만약 스택의 맨 위에 있는 글자와 동일하다면 연속하는 문자이므로
            // 스택의 pop 메소드을 이용하여 제거한다.
            if (!stack.empty() && stack.peek() == cryptogram.charAt(i))
                stack.pop();
            else
                stack.push(cryptogram.charAt(i));
        }

        // 스택에 있는 문자들을 StringBuilder를 이용해 연결한다.
        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        // 이때 스택의 LIFO 특성으로 인해 뒤집힌 채로 구성되므로
        // 정답은 StringBuilder의 reverse 메소드를 이용해 구한다.
        answer = sb.reverse().toString();
        return answer;
    }
}
