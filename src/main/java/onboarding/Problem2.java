package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char[] answer = cryptogram.toCharArray();

    }

    public static boolean isNotEmptyAndEquals(Stack<Character> stack, char answer) {
        return !stack.empty() && stack.peek().equals(answer);
    }
}
