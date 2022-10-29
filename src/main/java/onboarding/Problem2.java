package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String[] characters = cryptogram.split("");
        Stack<String> characterStack = new Stack<>();
        for (String character : characters) {
            if (characterStack.isEmpty()) {
                characterStack.add(character);
                continue;
            }
            if (characterStack.peek().equals(character)) {
                removeContinueDuplicateCharacters(characterStack, character);
            } else {
                characterStack.add(character);
            }
        }
        return stackChangeString(characterStack);
    }

    /**
     * 연속된 중복 character 제거
     *
     * @param stack character 가 담긴 stack
     * @param str   character
     * @return 연속된 중복 문자가 제거된 stack
     */
    private static Stack<String> removeContinueDuplicateCharacters(Stack<String> stack, String str) {
        if (stack.isEmpty()) {
            return stack;
        } else if (stack.peek().equals(str)) {
            stack.pop();
            return removeContinueDuplicateCharacters(stack, str);
        }
        return stack;
    }

    /**
     * stack 을 String 으로 변환
     *
     * @param stack character 가 담긴 stack
     * @return String
     */
    private static String stackChangeString(Stack<String> stack) {
        if (stack.isEmpty()) {
            return "";
        }
        return String.join("", stack);
    }
}