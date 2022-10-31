package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = stringDeduplication(cryptogram);
        return answer;
    }

    private static String stringDeduplication(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char[] alphabets = getAlphabets(cryptogram);
        for (int i = 0; i < alphabets.length; i++) {
            char alphabet = alphabets[i];
            if (!stack.isEmpty()) {
                // peek 한 값이 charAt 값과 같으면 pop
                if (stack.peek() == alphabets[i]) {
                    stack.pop();
                    while (i < alphabets.length - 1 && alphabet == alphabets[i + 1]) {
                        i++;
                    }
                } else {
                    stack.push(alphabet);
                }
            } else {
                stack.push(alphabet);
            }
        }
        return makeStackToString(stack);
    }
    private static String makeStackToString(Stack<Character> stack) {
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.reverse().toString();
    }

    private static char[] getAlphabets(String cryptogram) {
        return cryptogram.toCharArray();
    }
}
