package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = decode(cryptogram);

        return answer;
    }

    private static String decode(String cryptogram) {
        Stack<Character> stack = checkDuplicateCharacter(cryptogram);

        String decodingResult = getDecodingResult(stack);

        return decodingResult;
    }

    private static Stack<Character> checkDuplicateCharacter(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char prevRemoved = '.';

        for (int i = 0; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == prevRemoved && prevRemoved != '.')
                continue;

            prevRemoved = removeDuplicateCharacter(stack, cryptogram, i);
        }

        return stack;
    }

    private static char removeDuplicateCharacter(Stack<Character> stack, String cryptogram, int idx) {
        char prevRemoved = '.';
        if (stack.empty()) {
            stack.push(cryptogram.charAt(idx));
            return prevRemoved;
        }

        if (stack.peek() != cryptogram.charAt(idx)) {
            stack.push(cryptogram.charAt(idx));
            return prevRemoved;
        }

        if (stack.peek() == cryptogram.charAt(idx)) {
            while (!stack.empty() && stack.peek() == cryptogram.charAt(idx)) {
                prevRemoved = stack.pop();
            }
        }

        return prevRemoved;
    }


    private static String getDecodingResult(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();

        while (!stack.empty()) {
            sb.append(stack.peek());
            stack.pop();
        }

        sb.reverse();
        String ret = sb.toString();

        return ret;
    }
}
