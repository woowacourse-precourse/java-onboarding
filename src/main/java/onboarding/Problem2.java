package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        int len = 0;
        Stack<Character> stack = makeStack(cryptogram);

        return answer;
    }

    private static Stack<Character> makeStack(String cryptogram) {
        Stack<Character> stack = new Stack<Character>();
        char[] ch = cryptogram.toCharArray();
        for (char c : ch) {
            stack.push(c);
        }
        return stack;
    }

}

