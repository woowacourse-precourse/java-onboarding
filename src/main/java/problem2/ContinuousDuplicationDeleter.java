package problem2;

import java.util.List;
import java.util.Stack;

public class ContinuousDuplicationDeleter {
    public static String deleteFrom(String target) {
        Stack<Character> result = new Stack<>();

        for (int i = 0; i < target.length(); i++) {

            String t = (i == target.length() - 1) ?
                            target.substring(i) : target.substring(i, i + 2);
            deleteDuplication(result, t);

        }

        return asString(result);
    }

    private static void deleteDuplication(Stack<Character> result, String t) {
        if (isSameWithPrev(result, t.charAt(0)) && isDifferentWithNext(t)) {
            deleteFrom(result, t.charAt(0));
            return;
        }
        result.push(t.charAt(0));
    }

    private static boolean isSameWithPrev(Stack<Character> stack, Character curr) {
        return !stack.isEmpty() && stack.peek().equals(curr);
    }

    private static boolean isDifferentWithNext(String target) {
        return target.length() == 1 || target.charAt(0) != target.charAt(1);
    }

    private static void deleteFrom(Stack<Character> stack, char toDelete) {
        while (!stack.isEmpty() && stack.peek().equals(toDelete)) {
            stack.pop();
        }
    }


    private static String asString(List<Character> characters) {
        StringBuilder sb = new StringBuilder();

        for (Character character : characters) {
            sb.append(character);
        }

        return sb.toString();
    }
}
