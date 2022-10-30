package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Character> lower_dict = makeDictionary('a', 'z');
        HashMap<Character, Character> upper_dict = makeDictionary('A', 'Z');
        return answer;
    }

    public static HashMap<Character, Character> makeDictionary(Character start, Character end) {
        HashMap<Character, Character> dict = new HashMap<>();
        Character dict_word = end;
        for(Character c = start; c <= end; c++) {
            dict.put(c, dict_word);
            dict_word--;
        }
        return dict;
    }
}
