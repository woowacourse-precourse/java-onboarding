package onboarding.problem4.domain;

public class Word {

    private static final char BLANK = ' ';

    /**
     * 대문자와, 대응되는 대문자의 아스키코드를 더한 값
     */
    private static final int UPPER_CASE_COMPLEMENT = 155;

    /**
     * 소문자와, 대응되는 소문자의 아스키코드를 더한 값
     */
    private static final int LOWER_CASE_COMPLEMENT = 219;

    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public String value() {
        return word;
    }

    public Word reverse() {
        StringBuilder sb = new StringBuilder();

        word.chars()
                .mapToObj(this::reverseChar)
                .forEach(sb::append);
        return new Word(sb.toString());
    }

    private char reverseChar(int ascii) {
        if (!Character.isAlphabetic(ascii)) {
            return BLANK;
        }

        return (char) (isLowerCase(ascii)
                ? LOWER_CASE_COMPLEMENT - ascii
                : UPPER_CASE_COMPLEMENT - ascii);
    }

    private static boolean isLowerCase(int ascii) {
        return ('a' <= ascii) && (ascii <= 'z');
    }
}
