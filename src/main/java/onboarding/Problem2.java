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
        char pointer = alphabets[0];
        stack.push(pointer);
        boolean removeFlag = false;
        for (int i = 1; i < alphabets.length; i++) {
            char curAlpha = alphabets[i];
            if (stack.isEmpty()) {
                stack.push(curAlpha);
            } else {
                if (pointer == curAlpha) {
                    if (!removeFlag) {
                        removeFlag = true;
                    }
                }
                else {
                    if (removeFlag) {
                        stack.pop();
                        pointer = stack.peek();
                        removeFlag = false;
                        i--;
                    }
                    else {
                        stack.push(curAlpha);
                        pointer = stack.peek();
                        removeFlag = false;
                    }
                }
            }
        }
        if (!stack.isEmpty() && removeFlag) {
            stack.pop();
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
