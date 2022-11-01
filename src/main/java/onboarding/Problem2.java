package onboarding;

import java.util.Stack;

public class Problem2 {
    public static final int MAX_LENGTH = 1000;

    public static final char FIRST_LETTER = 'a';
    public static final char LAST_LETTER = 'z';

    private static Stack<Character> charStack;

    public static String solution(String cryptogram) {

        try {
            validate(cryptogram);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        deleteContinuousAndDuplicatedLetters(cryptogram);

        return convertStackToString();
    }

    public static void validate(String cryptogram) {
        validateLength(cryptogram);
        validateIsLower(cryptogram);
    }

    public static void validateLength(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("허용되지 않은 길이의 문자열입니다.");
        }
    }

    public static void validateIsLower(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            char letter = cryptogram.charAt(i);
            checkLetterIsLower(letter);
        }
    }

    public static void checkLetterIsLower(char letter) {
        if (letter < FIRST_LETTER || letter > LAST_LETTER) {
            throw new IllegalArgumentException("소문자가 아닌 다른 값이 포함되어 있습니다.");
        }
    }

    private static void deleteContinuousAndDuplicatedLetters(String cryptogram) {
        charStack = new Stack<>();
        char[] letters = cryptogram.toCharArray();

        for (char letter : letters) {
            deleteContinuousAndDuplicatedLetter(letter);
        }
    }

    private static void deleteContinuousAndDuplicatedLetter(char letter) {
        if (isStackNotEmptyAndTopEqualToLetter(letter)) {
            charStack.pop();
            return;
        }

        charStack.push(letter);
    }

    private static boolean isStackNotEmptyAndTopEqualToLetter(char letter) {
        return ((!charStack.isEmpty()) && charStack.peek() == letter);
    }

    private static String convertStackToString() {
        StringBuilder sb = new StringBuilder();

        for (char letter : charStack) {
            sb.append(letter);
        }

        return sb.toString();
    }
}
