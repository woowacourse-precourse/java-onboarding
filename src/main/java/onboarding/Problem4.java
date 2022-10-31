package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static final Map<Character, Character> SPELLING_CONVERT = defineSpellingConvert();
    private static final int UPPERCASE_ASCII_START_NUMBER = 65;
    private static final int LOWERCASE_ASCII_START_NUMBER = 97;
    private static final int ALLCASE_SPELLING_TERM = 25;

    public static String solution(String word) {
        return wordConvert(word);
    }

    private static HashMap<Character,Character> defineSpellingConvert(){
        HashMap<Character, Character> wordConvertMap = new HashMap<>();
        for (int i = 0; i < ALLCASE_SPELLING_TERM+1; i++) {
            wordConvertMap.put((char)(UPPERCASE_ASCII_START_NUMBER+i),(char)(ALLCASE_SPELLING_TERM+UPPERCASE_ASCII_START_NUMBER-i));
            wordConvertMap.put((char)(LOWERCASE_ASCII_START_NUMBER+i),(char)(ALLCASE_SPELLING_TERM+LOWERCASE_ASCII_START_NUMBER-i));
        }
        return wordConvertMap;
    }

    private static char[] wordToChar(String word){
        return word.toCharArray();
    }
    private static Character wordChange(Character wordCharacter){
        if(SPELLING_CONVERT.get(wordCharacter) == null){
            return wordCharacter;
        }
        return SPELLING_CONVERT.get(wordCharacter);
    }

    private static String wordLoop(char[] wordCharacters,String reverseWord){
        StringBuilder reverseWordBuilder = new StringBuilder(reverseWord);
        for (char wordCharacter : wordCharacters) {
            reverseWordBuilder.append(wordChange(wordCharacter));
        }
        reverseWord = reverseWordBuilder.toString();
        return reverseWord;
    }

    private static String wordConvert(String word){
        String reverseWord = "";
        return wordLoop(wordToChar(word),reverseWord);
    }
}
