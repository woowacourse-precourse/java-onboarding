package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<Character>();
        char prevChar = 'X';
        for (int i = 0; i < cryptogram.length(); i++) {
            char currentChar = cryptogram.charAt(i);
            if (stack.empty()){
                if (currentChar != prevChar)
                    stack.push(currentChar);
            } else{
                if (stack.peek() == currentChar){
                    stack.pop();
                } else if (currentChar != prevChar){
                    stack.push(currentChar);
                }
            }
            prevChar = currentChar;
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.empty()) {
            answer.insert(0, stack.pop());
        }

        return answer.toString();
    }
}
