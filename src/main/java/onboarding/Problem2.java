package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = deleteDupChar(cryptogram);
        return answer;
    }

    private static String deleteDupChar(String string) {
        Stack<Character> stack = new Stack<Character>();
        Character temp = ' ';
        stack.push(string.charAt(0));
        for (int i = 1; i < string.length(); i++) {
            if (temp.equals(string.charAt(i))) continue;
            if (stack.peek().equals(string.charAt(i))) {
                temp = stack.pop();
                continue;
            }
            stack.push(string.charAt(i));
        }
        return stack.stream()
                .map(a -> a.toString())
                .collect(Collectors.joining(""));
    }
}
