package onboarding;


import java.util.HashMap;

public class Problem4 {
    private static final int ALPHABET_LENGTH = 26;

    private static void addUpperToDictionary(HashMap<Character, Character> greenFrogDictionary){
        char startCharacter = 'A';
        char endCharacter = 'Z';

        for(int i = 0; i < ALPHABET_LENGTH; i++){
            greenFrogDictionary.put(startCharacter++, endCharacter--);
        }
    }

    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Character> greenFrogDictionary = new HashMap<>();

        return answer;
    }
}
