package onboarding;

import java.util.Stack;

public class Problem2 {
    public static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
    }
    public static String solution(String cryptogram) {
        String browoanoommnaon = deleteConsecutiveDuplicateCharacters(cryptogram);
        return browoanoommnaon;
    }

    private static String deleteConsecutiveDuplicateCharacters(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);
            if (i != 0) {
                if (!findDuplicatedCharactersAndPop(c)) {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    private static boolean findDuplicatedCharactersAndPop(char c) {
        if (stack.peek() == c) {
            stack.pop();
            return true;
        } else {
            return false;
        }
    }
}