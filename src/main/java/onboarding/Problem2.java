package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!validation(cryptogram)) return "ERROR";
        Stack<Character> answerStack = new Stack<>();
        boolean delete = false;
        for (char c : cryptogram.toCharArray()) {
            if (answerStack.isEmpty()) {
                answerStack.push(c);
                continue;
            }
            if (answerStack.peek() == c) {
                delete = true;
                continue;
            }
            if (delete) {
                answerStack.pop();
            }
            delete = (answerStack.peek() == c);
            if (!delete) {
                answerStack.push(c);
            }
        }
        if (delete) {
            answerStack.pop();
        }
        StringBuilder answer = new StringBuilder();
        answerStack.forEach(answer::append);
        return answer.toString();
    }

    static boolean validation(String cryptogram) {
        int length = cryptogram.length();
        if (length == 0 || length > 1000) return false;
        for (char c : cryptogram.toCharArray()) {
            if (!Character.isLowerCase(c)) return false;
        }
        return true;
    }
}
