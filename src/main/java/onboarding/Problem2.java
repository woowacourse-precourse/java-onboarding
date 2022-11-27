package onboarding;

import java.util.Iterator;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        for (int index = 0; index < cryptogram.length(); index++) {
            char alphabet = cryptogram.charAt(index);
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

        StringBuilder answer = new StringBuilder();
        Iterator<Character> iterator = stack.iterator();
        while (iterator.hasNext()) {
            answer.append(iterator.next());
        }
        return answer.toString();
    }
}
