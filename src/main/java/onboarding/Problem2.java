package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> initialStack = new Stack<>();

        makeInitialStack(cryptogram, initialStack);

        return answer.toString();
    }


    private static void makeInitialStack(String cryptogram, Stack<Character> stackOrigin) {
        stackOrigin.push('A');
        for (char crypto : cryptogram.toCharArray()) {
            stackOrigin.push(crypto);
        }
    }
}
