package problem2;

import java.util.Objects;

public class DuplicateCryptogramDecoder {
    private static final String ERR_EMPTY_CODE = "암호는 1 이상 1000 이하 길이를 가져야 합니다.";
    private static final String ERR_LOWER_CASE = "암호는 영어 소문자로만 구성되어야 합니다.";
    private static final int LENGTH_LOWER_BOUNDS = 1;
    private static final int LENGTH_UPPER_BOUNDS = 1000;
    private static final char LETTER_LOWER_BOUNDS = 'a';
    private static final char LETTER_UPPER_BOUNDS = 'z';

    public static String decode(String cryptogram) {
        validateLength(cryptogram);
        validateLowerCase(cryptogram);
        while (ContinuousDuplicationDeleter.hasDuplication(cryptogram)) {
            cryptogram = ContinuousDuplicationDeleter.deleteFrom(cryptogram);
        }
        return cryptogram;
    }

    private static void validateLength(String cryptogram) {
        if (Objects.requireNonNull(cryptogram).length() < LENGTH_LOWER_BOUNDS
                                ||  cryptogram.length() > LENGTH_UPPER_BOUNDS)
            throw new IllegalArgumentException(ERR_EMPTY_CODE);

    }

    private static void validateLowerCase(String cryptogram) {
        for (char letter : cryptogram.toCharArray()) {
            validateLowerCase(letter);
        }
    }

    private static void validateLowerCase(char letter) {
        if (letter < LETTER_LOWER_BOUNDS || letter > LETTER_UPPER_BOUNDS)
            throw new IllegalArgumentException(ERR_LOWER_CASE);
    }
}
