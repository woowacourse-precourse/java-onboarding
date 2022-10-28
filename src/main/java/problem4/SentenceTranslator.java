package problem4;

import static java.lang.Character.*;

public class SentenceTranslator {

    public static final char DEFAULT_ALPHABET_A = 'A';
    public static final int ALPHABET_MAX_INDEX = 25;

    public char translate(char alphabet) {
        if (!isAlphabetic(alphabet)) {
            return alphabet;
        }

        int temp = alphabet - DEFAULT_ALPHABET_A;
        temp = ALPHABET_MAX_INDEX - temp;

        return (char) (temp + DEFAULT_ALPHABET_A);
    }
}
