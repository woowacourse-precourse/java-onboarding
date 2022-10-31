package onboarding;

import java.util.Stack;

public class Problem2 {

    /**
     * 입력받은 문자열을 decrypt 한다.
     * @param input
     * @return
     */
    private static String decryptString (String input) {
        Stack<Character> inputStack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (inputStack.empty()) {
                inputStack.push(input.charAt(i));
                continue;
            }
            if (inputStack.peek() == input.charAt(i)) {
                inputStack.pop();
                continue;
            }
            inputStack.push(input.charAt(i));
        }

        while (!inputStack.empty()) {
            sb.append(inputStack.peek());
            inputStack.pop();
        }

        sb = sb.reverse();
        return sb.toString();
    }

    public static String solution(String cryptogram) {
        return decryptString(cryptogram);
    }
}
