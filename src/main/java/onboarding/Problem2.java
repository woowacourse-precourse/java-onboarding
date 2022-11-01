package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        char[] chars = cryptogram.toCharArray();
        Stack<Character> answerStack = new Stack<>();
        int countSameCharacter = 0;

        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];
            if (answerStack.empty()) {
                answerStack.push(character);
            } else {
                if (answerStack.peek() != character) {
                    while (countSameCharacter > 0) {
                        answerStack.pop();
                        countSameCharacter--;
                    }
                }
                if (!answerStack.isEmpty() && answerStack.peek() == character) {
                    if (countSameCharacter == 0) {
                        countSameCharacter++;
                    }
                    countSameCharacter++;
                }
                answerStack.push(character);
            }
        }
        while (countSameCharacter > 0) {
            answerStack.pop();
            countSameCharacter--;
        }

        answerStack.forEach(answer::append);
        return answer.toString();
    }
}
