package onboarding;

import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem2 {

    private static final int TWO = 2;
    private static final int INPUT_LEN_MIN = 1;
    private static final int INPUT_LEN_MAX = 1000;
    private static final String LOWER_ALPHABET_REGEX = "^[a-z]*$";

    public static String solution(String cryptogram) {
        validateCryptogram(cryptogram);
        return removeDuplicatedStr(cryptogram);
    }

    private static String removeDuplicatedStr(String cryptogram) {
        Stack<String> stack = new Stack<>();

        for (char word : cryptogram.toCharArray()) {
            stack.add(String.valueOf(word));
            removeDuplicatedStrInStack(stack);
        }
        return stack.stream()
            .collect(Collectors.joining());
    }

    private static void removeDuplicatedStrInStack(Stack<String> stack) {
        while (stack.size() >= TWO) {
            String word1 = stack.pop();
            String word2 = stack.pop();

            if (!word1.equals(word2)) {
                stack.add(word2);
                stack.add(word1);
                break;
            }
        }
    }

    private static void validateCryptogram(String cryptogram) {
        if (!isValidCryptogramForm(cryptogram) || !isValidCryptogramLen(cryptogram)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidCryptogramLen(String cryptogram) {
        return cryptogram.length() >= INPUT_LEN_MIN && cryptogram.length() <= INPUT_LEN_MAX;
    }

    private static boolean isValidCryptogramForm(String cryptogram) {
        return Pattern.matches(LOWER_ALPHABET_REGEX, cryptogram);
    }
}