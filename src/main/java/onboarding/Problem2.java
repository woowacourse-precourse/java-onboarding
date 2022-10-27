package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char lastDeleteAlphabet = ' ';
        char[] alphabetArray = cryptogram.toCharArray();
        for (char alphabet : alphabetArray) {
            if (stack.isEmpty()) {
                stack.push(alphabet);
                continue;
            }
            char forefrontAlphabet = stack.peek();
            if (alphabet == forefrontAlphabet) {
                stack.pop();
                lastDeleteAlphabet = alphabet;
                continue;
            }
            if (alphabet == lastDeleteAlphabet) {
                continue;
            }
            stack.push(alphabet);
            lastDeleteAlphabet = ' ';
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String answer = sb.reverse().toString();
        return answer;
    }
}