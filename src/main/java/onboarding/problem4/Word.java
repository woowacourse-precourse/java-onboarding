package onboarding.problem4;

import java.util.stream.Collectors;

public class Word {

    private static final int UPPER_TYPE = 1;
    private static final int LOWER_TYPE = 2;

    private final int MIN_WORD_LENGTH = 1;
    private final int MAX_WORD_LENGTH = 1_000;

    private String word;

    public Word(String word) {
        validateWord(word);
        this.word = word;
    }

    private void validateWord(String word) {
        if (isOutOfBounds(word)) throw new IllegalArgumentException("word is out of bounds");
    }

    private boolean isOutOfBounds(String word) {
        return word.length() < MIN_WORD_LENGTH || word.length() > MAX_WORD_LENGTH;
    }

    private static String convert(int ch) {
        if (!isAlphabet(ch)) return String.valueOf((char) ch);
        return Character.isUpperCase(ch) ? uppercaseConvert(ch) : lowercaseConvert(ch);
    }

    private static boolean isAlphabet(int ch) {
        int type = Character.getType(ch);
        return type == UPPER_TYPE || type == LOWER_TYPE;
    }

    private static String lowercaseConvert(int ch) {

        int offset = 'z' - ch;

        return String.valueOf((char) ('a' + offset));
    }

    private static String uppercaseConvert(int ch) {

        int offset = 'Z' - ch;

        return String.valueOf((char) ('A' + offset));
    }

    public String convert() {
        return word.codePoints()
                .map(i -> (char) i)
                .mapToObj(Word::convert)
                .collect(Collectors.joining(""));
    }
}
