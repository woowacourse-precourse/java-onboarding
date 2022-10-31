package onboarding.problem4;

import java.util.ArrayList;
import java.util.List;

public class FrogConverter extends AlphabetConverter {
    /**
     * ASCII-CODE
     * A-Z : 65 - 90
     * a-z : 97 - 122
     */


    /**
     * 4.1
     * 청개구리의 규칙은 알파벳들의 아스키 코드를 이용해 구분
     */
    @Override
    public char convert(char alphabet) {
        // uppercase
        if ((int) alphabet <= ASCII_Z)
            return (char) (ASCII_Z - ((int) alphabet - ASCII_A));

        // lowercase
        if ((int) alphabet >= ASCII_a)
            return (char) (ASCII_z - ((int) alphabet - ASCII_a));

        return alphabet;
    }

    @Override
    public String convertWord(String word) {
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (isAlphabet(word.charAt(i)))
                chars.add(this.convert(word.charAt(i)));
            else
                chars.add(word.charAt(i));
        }

        return listToString(chars);
    }
}