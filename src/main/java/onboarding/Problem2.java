package onboarding;

import java.util.Objects;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        // 1. Import and initialize stack to decode cryptogram
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {

            // 2. Get current character
            String w = Character.toString(cryptogram.charAt(i));

            // 3. Main logic
            // 3-1. If the stack is empty or the character doesn't overlap: push
            if (stack.size() == 0 || !Objects.equals(stack.peek(), w)) {
                stack.push(w);
            }
            // 3-2. If the character overlap
            else if (Objects.equals(stack.peek(), w)) {
                stack.pop();
            }
        }

        // 3. return answer
        return String.join("", stack);

    }
}