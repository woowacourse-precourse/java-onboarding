package onboarding.problem4;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class Transformation {
    public static String getWord(String word) {
        String newWord = "";
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            builder.append(((char) transformAlphabet(character)));
        }

        return builder.toString();
    }

    private static int transformAlphabet(char character) {
        if (isLowerCase(character)) {
            return (char) ('a' + (25 - (character - 'a')));
        }

        if (isUpperCase(character)) {
            return (char) ('A' + (25 - (character - 'A')));
        }

        return character;
    }
}
