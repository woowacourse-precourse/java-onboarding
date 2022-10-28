package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>();

        String[] alphabets = cryptogram.split("");
        String sameAlphabet = "";
        for (String alphabet : alphabets) {
            if (stack.isEmpty()) {
                stack.push(alphabet);
                sameAlphabet = "";
                continue;
            }

            if (sameAlphabet.equals(alphabet)) {
                continue;
            }

            String peek = stack.peek();
            if (alphabet.equals(peek)) {
                stack.pop();
                sameAlphabet = peek;
                continue;
            }

            stack.add(alphabet);
        }

        return String.join("", stack);
    }
}
