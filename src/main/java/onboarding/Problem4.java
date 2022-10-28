package onboarding;

import java.util.HashMap;

public class Problem4 {
    public HashMap<Character, Character> makeDictionary(){
        HashMap<Character, Character> dictionary = new HashMap<>();
        return dictionary;
    }

    public static String solution(String word) {
        Problem4 T = new Problem4();
        StringBuilder answer = new StringBuilder();

        HashMap<Character, Character> dictionary = T.makeDictionary();

        for(char c : word.toCharArray()){
            if(Character.isAlphabetic(c)){
                answer.append(dictionary.get(c));
                continue;
            }
            answer.append(c);
        }
        return answer.toString();
    }
}
