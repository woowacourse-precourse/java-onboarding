package onboarding;


import java.util.HashMap;
import java.util.regex.Pattern;

public class Problem4 {
    private static final int ALPHABET_LENGTH = 26;

    private static void addUpperToDictionary(HashMap<Character, Character> greenFrogDictionary){
        char startCharacter = 'A';
        char endCharacter = 'Z';

        for(int i = 0; i < ALPHABET_LENGTH; i++){
            greenFrogDictionary.put(startCharacter++, endCharacter--);
        }
    }
    private static void addLowerToDictionary(HashMap<Character, Character> greenFrogDictionary){
        char startCharacter = 'a';
        char endCharacter = 'z';

        for(int i = 0; i < ALPHABET_LENGTH; i++){
            greenFrogDictionary.put(startCharacter++, endCharacter--);
        }
    }

    private static boolean isAlphabet(char character){
        return Pattern.matches("^[a-zA-Z]*$", String.valueOf(character));
    }

    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Character> greenFrogDictionary = new HashMap<>();

        addUpperToDictionary(greenFrogDictionary);
        addLowerToDictionary(greenFrogDictionary);

        for(int i = 0; i < word.length(); i++){
            char character = word.charAt(i);
            if(!isAlphabet(character)) {
                answer += character;
                continue;
            }
            answer += greenFrogDictionary.get(character);
        }

        return answer;
    }
}
