package onboarding;

import java.util.Iterator;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return formatAnswer(decrypt(cryptogram));
    }

    private static Stack<Character> decrypt(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        for (char alphabet : cryptogram.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(alphabet);
                continue;
            }
            char top = stack.pop();
            if (top != alphabet) {
                stack.push(top);
                stack.push(alphabet);
            }
        }
        return stack;
    }

    private static String formatAnswer(Stack<Character> stack) {
        StringBuilder answer = new StringBuilder();
        Iterator<Character> iterator = stack.iterator();
        while (iterator.hasNext()) {
            answer.append(iterator.next());
        }
        return answer.toString();
    }
}
