package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> answerStack = new Stack<>();
        
        for (int i = 0; i < cryptogram.length(); ++i) {
            if (!answerStack.isEmpty() && answerStack.peek() == cryptogram.charAt(i)) {
                answerStack.pop();
            } else {
                answerStack.push(cryptogram.charAt(i));
            }
        }

        // stack to string
        for (Character c : answerStack) {
            answer.append(c);
        }
        return answer.toString();
    }
}
