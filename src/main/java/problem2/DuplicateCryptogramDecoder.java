package problem2;

import java.util.Objects;
import java.util.Stack;

public class DuplicateCryptogramDecoder {
    private static final String ERR_EMPTY_CODE = "암호는 1 이상 1000 이하 길이를 가져야 합니다.";
    private static final String ERR_LOWER_CASE = "암호는 영어 소문자로만 구성되어야 합니다.";
    private static final int LENGTH_LOWER_BOUND = 1;
    private static final int LENGTH_UPPER_BOUND = 1000;
    private static final char LETTER_LOWER_BOUND = 'a';
    private static final char LETTER_UPPER_BOUND = 'z';

    public static String decode(String cryptogram) {
        validateLength(cryptogram);
        validateLowerCase(cryptogram);
        return deleteContinuousDuplication(cryptogram.toCharArray());
    }

    private static void validateLength(String cryptogram) {
        if (Objects.requireNonNull(cryptogram).length() < LENGTH_LOWER_BOUND
                                ||  cryptogram.length() > LENGTH_UPPER_BOUND)
            throw new IllegalArgumentException(ERR_EMPTY_CODE);

    }

    private static void validateLowerCase(String cryptogram) {
        for (char letter : cryptogram.toCharArray()) {
            validateLowerCase(letter);
        }
    }

    private static void validateLowerCase(char letter) {
        if (letter < LETTER_LOWER_BOUND || letter > LETTER_UPPER_BOUND)
            throw new IllegalArgumentException(ERR_LOWER_CASE);
    }

    private static String deleteContinuousDuplication(char[] cryptogram) {
        Stack<Character> lifo = new Stack<>();

        for (char letter : cryptogram) {
            deleteContinuousDuplication(lifo, letter);
        }

        return asString(lifo);
    }

    private static void deleteContinuousDuplication(Stack<Character> characters, char letter) {
        if (characters.isEmpty()) {
            characters.push(letter);
            return;
        }

        if (characters.peek() == letter) {
            characters.pop();
            return;
        }

        characters.push(letter);
    }

    private static String asString(Stack<Character> characters) {
        StringBuilder sb = new StringBuilder();

        for (Character character : characters) {
            sb.append(character);
        }

        return sb.toString();
    }
}
