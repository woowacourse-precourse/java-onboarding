package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            char curr = cryptogram.charAt(i);

            if (stack.empty()) stack.add(curr);
            else {
                char prev = stack.peek();

                if (curr != prev) stack.add(curr);
                else stack.pop();
            }
        }
        String answer = "";
        for (char s : stack) answer += s;

        return answer;
    }
}
