package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String convertStackIntoString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static Stack<Character> deleteDuplicateUsingStack(String str) {
        final int LEN = str.length();
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        int index = 1;
        char top = str.charAt(0);
        boolean isDuplicate = false;
        while(index < LEN) {
            char current = str.charAt(index);
            if(isDuplicate) {
                if(current == top) {
                    index++;
                } else {
                    stack.pop();
                    top = stack.peek();
                    isDuplicate = false;
                }
            } else {
                if(current == top) {
                    isDuplicate = true;
                    index++;
                    continue;
                } else {
                    stack.push(current);
                    top = current;
                    index++;
                }
            }

        }
        return stack;
    }
}
