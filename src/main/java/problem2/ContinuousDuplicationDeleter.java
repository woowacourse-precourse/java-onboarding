package problem2;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ContinuousDuplicationDeleter {
    public static String deleteFrom(String target) {
        Stack<Character> result = new Stack<>();

        for (int i = 0; i < target.length(); i++) {
            Character targetCharacter = target.charAt(i);
            Character nextCharacter = (i == target.length() - 1) ?
                    null : target.charAt(i + 1);

            deleteDuplication(result, targetCharacter, nextCharacter);
        }

        return asString(result);
    }

    private static void deleteDuplication(Stack<Character> result, Character targetCharacter, Character nextCharacter) {
        if (isSameWithPrev(result, targetCharacter) && isDifferentWithNext(targetCharacter, nextCharacter)) {
            deleteFrom(result, targetCharacter);
            return;
        }
        result.push(targetCharacter);
    }

    private static boolean isSameWithPrev(Stack<Character> stack, Character curr) {
        return !stack.isEmpty() && stack.peek().equals(curr);
    }

    private static boolean isDifferentWithNext(Character curr, Character next) {
        return !Objects.equals(curr, next);
    }

    private static void deleteFrom(Stack<Character> duplicationCharacters, char toDelete) {
        while (isSameWithPrev(duplicationCharacters, toDelete)) {
            duplicationCharacters.pop();
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
