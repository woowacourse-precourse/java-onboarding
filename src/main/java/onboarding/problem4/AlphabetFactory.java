package onboarding.problem4;

public class AlphabetFactory {

    private static final char UPPER_STANDARD_VALUE = ('A' + 'Z') / 2;
    private static final char LOWER_STANDARD_VALUE = ('a' + 'z') / 2;

    public static Character doConvert(char word) {
        if (Character.isUpperCase(word)) {
            return (char) convertAlphabet(UPPER_STANDARD_VALUE, word);
        }
        return (char) convertAlphabet(LOWER_STANDARD_VALUE, word);
    }

    private static int convertAlphabet(char standardValue, char word) {
        return word + (standardValue - word) * 2 + 1;
    }
}
