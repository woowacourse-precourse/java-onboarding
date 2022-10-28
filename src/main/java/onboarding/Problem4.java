package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    static List<Integer> getUpperCharIndex(char[] wordCharacter) {
        List<Integer> upperCharIndex = new ArrayList<>();
        for (int i = 0; i < wordCharacter.length; i++) {
            int asciiChar = (int)wordCharacter[i];
            if (asciiChar >= 97 & asciiChar <=122) {
                upperCharIndex.add(i);
            }
        }
        return upperCharIndex;
    }

    static char[] reverseWord(char[] wordCharacter) {
        for (int i = 0; i < wordCharacter.length; i++) {
            int asciiChar = (int)wordCharacter[i];
            if (asciiChar >= 97 & asciiChar <=122) {
                char reverseChar = (char)(122+97-asciiChar);
                wordCharacter[i] = reverseChar;
            }
        }
        return wordCharacter;
    }
}
