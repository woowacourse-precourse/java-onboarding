package problem2;

import java.util.Objects;

public class DuplicateCryptogramDecoder {
    private static final String ERR_EMPTY_CODE = "암호는 1 이상 1000 이하 길이를 가져야 합니다.";
    private static final String ERR_LOWER_CASE = "암호는 영어 소문자로만 구성되어야 합니다.";
    private static final int LENGTH_LOWER_BOUND = 1;
    private static final int LENGTH_UPPER_BOUND = 1000;

    public static String decode(String cryptogram) {
        validateLength(cryptogram);
        validateLowerCase(cryptogram);
        return deleteDuplication(cryptogram.toCharArray());
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
        if (letter < 'a' || letter > 'z')
            throw new IllegalArgumentException(ERR_LOWER_CASE);
    }
}
