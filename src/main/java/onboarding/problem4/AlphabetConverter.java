package onboarding.problem4;

import java.util.List;

public abstract class AlphabetConverter {

    final int ASCII_A = 65;
    final int ASCII_Z = 90;
    final int ASCII_a = 97;
    final int ASCII_z = 122;

    public boolean isAlphabet(char character) {
        if ((int) character >= ASCII_A && (int) character <= ASCII_Z)
            return true;


        if ((int) character >= ASCII_a && (int) character <= ASCII_z)
            return true;

        return false;
    }

    public String listToString(List<Character> characters) {
        StringBuilder sb = new StringBuilder();
        for (char c : characters)
            sb.append(c);

        return sb.toString();
    }

    public abstract char convert(char alphabet);
    public abstract String convertWord(String word);
}
