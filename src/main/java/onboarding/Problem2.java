package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stackOrigin = new Stack<>();
        Stack<Character> stackResult = new Stack<>();
        stackResult.push('A');

        makeStackOrigin(cryptogram, stackOrigin);
        makeStackResult(stackOrigin, stackResult);

        return answer.toString();
    }

    private static void makeStackResult(Stack<Character> stackOrigin, Stack<Character> stackResult) {
        int flag = 0;

        while (!stackOrigin.empty()) {
            char checkChar = stackOrigin.pop();
            flag = popResultStack(stackResult, flag, checkChar);
            flag = pushResultStack(stackResult, flag, checkChar);
        }
    }

    private static int pushResultStack(Stack<Character> stackResult, int flag, char checkChar) {
        return flag;
    }

    private static int popResultStack(Stack<Character> stackResult, int flag, char checkChar) {
        return flag;
    }

    private static void makeStackOrigin(String cryptogram, Stack<Character> stackOrigin) {
        stackOrigin.push('A');
        for (char crypto : cryptogram.toCharArray()) {
            stackOrigin.push(crypto);
        }
    }
}
