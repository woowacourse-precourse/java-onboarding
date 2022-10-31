package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        Stack<Character> stack = checkDuplication(cryptogram);
        Object[] toArray = stackToArray(stack);
        answer = getAnswer(toArray);
        return answer;
    }

    private static Stack<Character> checkDuplication(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        stack.push(cryptogram.charAt(0));
        char before = stack.peek();

        for (int i = 1; i < cryptogram.length(); i++) {
            char after = cryptogram.charAt(i);
            if (before == after) {
                stack.pop();
                if(!stack.isEmpty()) {
                    before = stack.peek();
                }
            } else {
                stack.push(cryptogram.charAt(i));
                before = cryptogram.charAt(i);
            }
        }
        return stack;
    }

    private static String getAnswer(Object[] toArray) {
        String sumLetter = "";
        for (Object o : toArray) {
            sumLetter += o;
        }
        return sumLetter;
    }

    private static Object[] stackToArray(Stack<Character> stack) {
        Object[] toArray = stack.toArray();
        return toArray;
    }
}
