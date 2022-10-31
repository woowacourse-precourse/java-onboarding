package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        /* ASCII 코드를 활용해 소문자, 대문자 알파벳을 반대로 변환*/
        List<Integer> upperCharIndex = getUpperCharIndex(word.toCharArray());   // 대문자 알파벳의 위치 리스트
        char[] wordCharacter = word.toLowerCase().toCharArray();    // 모든 알파벳을 소문자로 변환
        wordCharacter = reverseWord(wordCharacter);     // 소문자 알파벳을 반대로 변환
        wordCharacter = restoreUpperCharacter(wordCharacter, upperCharIndex);   // 대문자 알파벳 복원
        String answer = new String(wordCharacter);  // 문자열String으로 변환
        return answer;
    }

    static List<Integer>getUpperCharIndex(char[] wordCharacter) {
        List<Integer> upperCharIndex = new ArrayList<>();
        for (int i = 0; i < wordCharacter.length; i++) {
            int asciiChar = wordCharacter[i];
            if (asciiChar >= 65 & asciiChar <= 90) {
                upperCharIndex.add(i);
            }
        }
        return upperCharIndex;
    }

    static char[] reverseWord(char[] wordCharacter) {
        for (int i = 0; i < wordCharacter.length; i++) {
            int asciiChar = wordCharacter[i];
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