package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static final int UPPER_CASE_ALPHABET = 65;
    private static final int LOWER_CASE_ALPHABET = 97;
    private static final int LAST_LETTER_OF_ALPHABET = 25;

    // 청개구리 사전 만들기
    private static final HashMap<Character, Character> frogDict = makeFrogDictionary();
    
    public static String solution(String word) {
        String answer="";

        for (char letter : word.toCharArray()) {
            answer += convert(letter);
        }

        return answer;
    }

    private static char convert(char letter){
        if(Character.isAlphabetic(letter)) {
            return frogDict.get(letter);
        }
        return letter;
    }

    private static HashMap<Character, Character> makeFrogDictionary(){
        HashMap<Character, Character> map = new HashMap<>();

        for(int i=0;i<26;i++) {
            map.put((char) (UPPER_CASE_ALPHABET + i),
                    (char) (UPPER_CASE_ALPHABET + LAST_LETTER_OF_ALPHABET - i)); // 대문자 key-value
            map.put((char) (LOWER_CASE_ALPHABET + i),
                    (char) (LOWER_CASE_ALPHABET + LAST_LETTER_OF_ALPHABET - i)); // 소문자 key-value
        }
        return map;
    }
}
