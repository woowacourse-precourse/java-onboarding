package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    private static final Map<Character, Character> SPELLING_CONVERT = defineSpellingConvert();
    private static final int UPPERCASE_ASCII_START_NUMBER = 65;
    private static final int LOWERCASE_ASCII_START_NUMBER = 97;
    private static final int ALLCASE_SPELLING_TERM = 25;
    public static String solution(String word) {
        String answer = SPELLING_CONVERT.toString();
        return answer;
    }
    public static HashMap<Character,Character> defineSpellingConvert(){
        Map map = new HashMap<Character,Character>();
        for (int i = 0; i < ALLCASE_SPELLING_TERM+1; i++) {
            map.put((char)(UPPERCASE_ASCII_START_NUMBER+i),(char)(ALLCASE_SPELLING_TERM+UPPERCASE_ASCII_START_NUMBER-i));
            map.put((char)(LOWERCASE_ASCII_START_NUMBER+i),(char)(ALLCASE_SPELLING_TERM+LOWERCASE_ASCII_START_NUMBER-i));
        }
        return (HashMap<Character, Character>) map;
    }
}
