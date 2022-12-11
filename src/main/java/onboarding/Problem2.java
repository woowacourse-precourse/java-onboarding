package onboarding;

import java.util.Iterator;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return formatAnswer(decrypt(cryptogram));
    }

    private static Stack<Character> decrypt(String cryptogram) {
        Stack<Character> result = new Stack<>();
        for (char alphabet : cryptogram.toCharArray()) {
            if (result.isEmpty()) {
                result.push(alphabet);
                continue;
            }
            char top = result.pop();
            if (top != alphabet) {
                result.push(top);
                result.push(alphabet);
            }
        }
        return result;
    }

    private static String formatAnswer(Stack<Character> stack) {
        StringBuilder answer = new StringBuilder();
        Iterator<Character> word = stack.iterator();
        while (word.hasNext()) {
            answer.append(word.next());
        }
        return answer.toString();
    }
}
