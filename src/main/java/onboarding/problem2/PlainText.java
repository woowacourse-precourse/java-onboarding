package onboarding.problem2;

import java.util.Stack;

public class PlainText {
    public static String decodeCipherText(String ciphertext) {
        Stack<Character> stack = new Stack<>();
        for (Character character : ciphertext.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(character);
                continue;
            }
            if (character != stack.lastElement()) {
                deleteDuplicatedItem(stack);
            }
            stack.push(character);
        }
        if (stack.isEmpty()) {
            return "";
        }
        deleteDuplicatedItem(stack);
        return convertCharacterStackToString(stack);
    }

    private static void deleteDuplicatedItem(Stack<Character> stack) {
        Character item = stack.pop();
        boolean flag = true;
        while (!stack.isEmpty() && item == stack.lastElement()) {
            stack.pop();
            flag = false;
        }
        if (flag) {
            stack.push(item);
        }
    }

    private static String convertCharacterStackToString(Stack<Character> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
