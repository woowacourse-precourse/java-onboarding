package onboarding;

import java.util.Stack;

public class Problem2 {

    public static boolean checkNotDuplicate(String string) {
        for (int i=1; i<string.length(); i++)  {
            if (string.charAt(i-1) == string.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkStackPop(Stack<Character> stack, String code, char before, int idx) {
        if (!stack.isEmpty() && before == code.charAt(idx)&& code.charAt(idx) == stack.peek()) {
            return true;
        }
        return false;
    }

    public static String removeDuplication(String code) {
        Stack<Character> stack = new Stack<>();
        stack.push(code.charAt(0));
        char before = code.charAt(0);
        for (int i=1; i<code.length(); i++) {
            if (checkStackPop(stack, code, before, i)) {
                stack.pop();
            }
            else if (before != code.charAt(i)) {
                stack.push(code.charAt(i));
            }
            before = code.charAt(i);
        }
        String newCode = stackToString(stack);
        return newCode;
    }

    public static String stackToString(Stack<Character> stack) {
        String string = "";
        for (char s : stack) {
            string += s;
        }
        return string;
    }

    public static String refeatRemove(String code) {
        while (checkNotDuplicate(code)) {
            code = removeDuplication(code);
        }
        return code;
    }
    public static String solution(String cryptogram) {
        String answer = refeatRemove(cryptogram);
        return answer;
    }
}
