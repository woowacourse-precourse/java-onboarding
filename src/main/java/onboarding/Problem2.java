package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        char[] charArray = cryptogram.toCharArray();

        for (char curruntCharacter : charArray) {
            if (!stack.empty() && stack.peek() == curruntCharacter) {
                stack.pop();
                continue;
            }
            stack.push(curruntCharacter);
        }
        stack.forEach(answer::append);

        return answer.toString();
    }
}
