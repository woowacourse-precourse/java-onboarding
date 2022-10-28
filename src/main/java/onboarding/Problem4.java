package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        List<Integer> upperCharIndex = getUpperCharIndex(word.toCharArray());
        char[] wordCharacter = word.toLowerCase().toCharArray();
        wordCharacter = reverseWord(wordCharacter);
        wordCharacter = restoreUpperCharacter(wordCharacter, upperCharIndex);
        String answer = new String(wordCharacter);
        return answer;
    }

    static List<Integer>getUpperCharIndex(char[] wordCharacter) {
        List<Integer> upperCharIndex = new ArrayList<>();
        for (int i = 0; i < wordCharacter.length; i++) {
            int asciiChar = (int)wordCharacter[i];
            if (asciiChar >= 65 & asciiChar <= 90) {
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

    static char[] restoreUpperCharacter(char[] wordCharacter, List<Integer> upperCharIndex) {
        for (int i : upperCharIndex) {
            wordCharacter[i] = Character.toUpperCase(wordCharacter[i]);
        }
        return wordCharacter;
    }
}