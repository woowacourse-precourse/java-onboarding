package problem4;

import static java.lang.Character.*;

public class SentenceTranslator {

    public static final char DEFAULT_UPPER_ALPHABET_A = 'A';
    public static final char DEFAULT_LOWER_ALPHABET_A = 'a';
    public static final int ALPHABET_MAX_INDEX = 25;
    public static final int START_INDEX = 0;

    public String translate(String sentence) {
        StringBuilder translationWord = new StringBuilder();

        for (int i = START_INDEX; i < sentence.length(); i++) {
            translationWord.append(translate(sentence.charAt(i)));
        }
        return translationWord.toString();
    }

    public char translate(char alphabet) {
        if (!isAlphabetic(alphabet)) {
            return alphabet;
        }
        if (isUpperCase(alphabet)) {
            return translateUpperCase(alphabet);
        }
        return translateLowerCase(alphabet);
    }

    private char translateLowerCase(char alphabet) {
        int temp = alphabet - DEFAULT_LOWER_ALPHABET_A;
        temp = ALPHABET_MAX_INDEX - temp;

        return (char) (temp + DEFAULT_LOWER_ALPHABET_A);
    }

    private char translateUpperCase(char alphabet) {
        int temp = alphabet - DEFAULT_UPPER_ALPHABET_A;
        temp = ALPHABET_MAX_INDEX - temp;

        return (char) (temp + DEFAULT_UPPER_ALPHABET_A);
    }
}
