package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Character> dict = makeDictionary();
        return answer;
    }

    public static HashMap<Character, Character> makeDictionary() {
        HashMap<Character, Character> dict = new HashMap<>();
        char alphabet = 'a';
        Character dict_word = 'z';
        for(alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            dict.put(alphabet, dict_word);
            dict_word--;
        }
        dict_word = 'Z';
        for(alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            dict.put(alphabet, dict_word);
            dict_word--;
        }

        return dict;
    }
}
