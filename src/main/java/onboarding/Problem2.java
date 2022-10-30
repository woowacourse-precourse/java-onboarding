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
        return toString(characterStack);
    }

    /**
     * 연속된 중복 character 제거한다.
     *
     * @param stack character 가 담긴 오브젝트
     * @param str   character
     * @return 연속된 중복 문자가 제거된 오브젝트를 반환한다.
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
     * String 으로 변환
     *
     * @param stack character 가 담긴 오브젝트
     * @return 문자열을 반환한다.
     */
    private static String toString(Stack<String> stack) {
        if (stack.isEmpty()) {
            return "";
        }
        return String.join("", stack);
    }
}