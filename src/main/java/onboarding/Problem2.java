package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> alphabets = new Stack<>();
        for (char c : cryptogram.toCharArray()) {
            if (alphabets.empty()) {
                alphabets.push(c);
                continue;
            }
            Character before = alphabets.peek();
            if (before == c) {
                alphabets.pop();
            } else {
                alphabets.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        alphabets.forEach(sb::append);
        return sb.toString();
    }
}
