package problem4;

import java.util.Objects;

public class WordConverter {
    private static final String ERR_WORD_LENGTH = "단어는 1 이상 1000 이하 길이를 가져야 합니다.";
    private static final String ERR_NON_ALPHABETIC_WORD = "단어는 영어와 공백 문자로만 구성되어야 합니다.";
    private static final int LENGTH_LOWER_BOUNDS = 1;
    private static final int LENGTH_UPPER_BOUNDS = 1000;
    private static final int UPPERCASE_TRANSLATION_NUMBER = 'A' + 'Z';
    private static final int LOWERCASE_TRANSLATION_NUMBER = 'a' + 'z';

    public static String convert(String word) {
        validateLength(word);
        char[] converted = convert(word.toCharArray());
        return new String(converted);
    }

    private static char[] convert(char[] word) {
        for (int i = 0; i < word.length; i++) {
            word[i] = convert(word[i]);
        }
        return word;
    }

    private static char convert(char letter) {
        if (Character.isLowerCase(letter)) {
            return (char) (LOWERCASE_TRANSLATION_NUMBER - letter);
        }
        if (Character.isUpperCase(letter)) {
            return (char) (UPPERCASE_TRANSLATION_NUMBER - letter);
        }
        return letter;
    }

    private static void validateLength(String word) {
        if (Objects.requireNonNull(word).length() < LENGTH_LOWER_BOUNDS
                                ||  word.length() > LENGTH_UPPER_BOUNDS)
            throw new IllegalArgumentException(ERR_WORD_LENGTH);
    }
}
