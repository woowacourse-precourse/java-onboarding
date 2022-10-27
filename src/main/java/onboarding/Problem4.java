package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static final Map<Character, Character> SPELLING_CONVERT = defineSpellingConvert();
    private static final int UPPERCASE_ASCII_START_NUMBER = 65;
    private static final int LOWERCASE_ASCII_START_NUMBER = 97;
    private static final int ALLCASE_SPELLING_TERM = 25;
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static HashMap<Character,Character> defineSpellingConvert(){
        Map map = new HashMap<Character,Character>();
        for (int i = 0; i < ALLCASE_SPELLING_TERM+1; i++) {
            map.put((char)(UPPERCASE_ASCII_START_NUMBER+i),(char)(ALLCASE_SPELLING_TERM+UPPERCASE_ASCII_START_NUMBER-i));
            map.put((char)(LOWERCASE_ASCII_START_NUMBER+i),(char)(ALLCASE_SPELLING_TERM+LOWERCASE_ASCII_START_NUMBER-i));
        }
        return (HashMap<Character, Character>) map;
    }
    public static char[] wordToChar(String word){
        return word.toCharArray();
    }
    private static Character wordChange(Character wordCharacter){
        return SPELLING_CONVERT.get(wordCharacter);
    }
    private static String wordLoop(char[] wordCharacters,String reverseWord){
        for (char wordCharacter : wordCharacters) {
            reverseWord += wordChange(wordCharacter);
        }
        return reverseWord;
    }
    private static String wordConvert(String word){
        String reverseWord = "";
        return wordLoop(wordToChar(word),reverseWord);
    }
}
