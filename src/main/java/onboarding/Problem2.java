package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for(char currentCharacter : cryptogram.toCharArray()) {
            if( !stack.isEmpty() && stack.peek() == currentCharacter) {
                stack.pop();
                continue;
            }
            stack.push(currentCharacter);
        }

        StringBuilder answer = new StringBuilder();
        stack.forEach(answer::append);
        return answer.toString();
    }
}
