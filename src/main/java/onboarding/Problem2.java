package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stackOrigin = new Stack<>();
        Stack<Character> stackResult = new Stack<>();

        makeStackOrigin(cryptogram, stackOrigin);
        makeStackResult(stackOrigin, stackResult);
        makeAnswer(answer, stackResult);

        return answer.toString();
    }

    private static void makeStackResult(Stack<Character> stackOrigin, Stack<Character> stackResult) {
        stackResult.push('A');
        int flag = 0;

        while (!stackOrigin.empty()) {
            char checkChar = stackOrigin.pop();
            flag = popResultStack(stackResult, flag, checkChar);
            flag = pushResultStack(stackResult, flag, checkChar);
        }
    }

    private static int pushResultStack(Stack<Character> stackResult, int flag, char checkChar) {
        if (stackResult.peek() == checkChar) {
            stackResult.push(checkChar);
            flag += 1;
        }

        if (flag == 0 && stackResult.peek() != checkChar) {
            stackResult.push(checkChar);
        }
        return flag;
    }

    private static int popResultStack(Stack<Character> stackResult, int flag, char checkChar) {
        if (flag > 0 && checkChar != stackResult.peek()) {
            for (int i = 0; i < flag + 1; i++) {
                stackResult.pop();
            }
            flag = 0;
        }
        return flag;
    }

    private static void makeStackOrigin(String cryptogram, Stack<Character> stackOrigin) {
        stackOrigin.push('A');
        for (char crypto : cryptogram.toCharArray()) {
            stackOrigin.push(crypto);
        }
    }

    private static void makeAnswer(StringBuilder answer, Stack<Character> stackResult) {
        stackResult.pop();
        int stackResultSize = stackResult.size();
        for (int i = 0; i < stackResultSize - 1; i++) {
            answer.append(stackResult.pop());
        }
    }
}
