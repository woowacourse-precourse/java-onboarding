package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<String> result = new Stack<>();
        String[] targets = cryptogram.split("");

        String top = "";
        for(String target : targets) {
            top = decode(target, top, result);
        }
        return getAnswerFromResult(result);
    }

    public static String decode(String target, String top, Stack<String> result) {
        if(canDecode(target, top, result)) {
            return result.push(target);
        }
        return top;
    }

    private static boolean canDecode(String target, String top, Stack<String> result) {
        if(isDuplicated(target, result)) {
            result.pop();
            return false;
        }
        return !top.equals(target);
    }

    private static boolean isDuplicated(String target, Stack<String> result) {
        return getTopFrom(result).equals(target);
    }

    private static String getTopFrom(Stack<String> result) {
        if (result.isEmpty()) {
            return "";
        }
        return result.peek();
    }

    private static String getAnswerFromResult(Stack<String> stack) {
        String answer = "";
        while (!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }
        return answer;
    }
}