package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Character> dict = makeDictionary();
        StringBuilder change_word = changeWord(word, dict);
        answer = change_word.toString();
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
    public static StringBuilder changeWord(String word, HashMap<Character, Character> dict) {
        StringBuilder change_word = new StringBuilder();
        char c;
        for(int i=0; i < word.length(); i++){
            c = word.charAt(i);
            if (c == ' ') change_word.append(' ');
            if (c != ' ') change_word.append(dict.get(c));
        }
        return change_word;
    }
}
