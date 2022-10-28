package problem4;

import java.util.Objects;

public class WordConverter {
    private static final String ERR_WORD_LENGTH = "단어는 1 이상 1000 이하 길이를 가져야 합니다.";
    private static final String ERR_NON_ALPHABETIC_WORD = "단어는 영어와 공백 문자로만 구성되어야 합니다.";
    private static final int LENGTH_LOWER_BOUNDS = 1;
    private static final int LENGTH_UPPER_BOUNDS = 1000;
    public static String convert(String word) {
        validate(word);
        return null;
    }

    private static void validate(String word) {
        validateLength(word);
        validateAlphabetic(word);
    }

    private static void validateLength(String word) {
        if (Objects.requireNonNull(word).length() < LENGTH_LOWER_BOUNDS
                                ||  word.length() > LENGTH_UPPER_BOUNDS)
            throw new IllegalArgumentException(ERR_WORD_LENGTH);
    }

    private static void validateAlphabetic(String word) {
        for (char letter : word.toCharArray()) {
            if (!Character.isAlphabetic(letter) && letter != ' ')
                throw new IllegalArgumentException(ERR_NON_ALPHABETIC_WORD);
        }
    }
}
