package onboarding;


import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        checkDuplicateChar(stack, cryptogram);
        return convertStackToString(stack);
    }

    public static void checkDuplicateChar(Stack<Character> stack, String target) {
        for (char c : target.toCharArray()) {
            if (checkStack(stack, c)) {
                stack.push(c);
                continue;
            }
            while (!checkStack(stack, c)) {
                stack.pop();
            }
        }
    }

    public static boolean checkStack(Stack<Character> stack, char c) {
        return stack.empty() || stack.peek() != c;
    }

    public static String convertStackToString(Stack<Character> stack) {
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

}