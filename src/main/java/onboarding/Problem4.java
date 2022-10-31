package onboarding;

import java.util.HashMap;

public class Problem4 {
    public HashMap<Character, Character> makeDictionary(){
        HashMap<Character, Character> dictionary = new HashMap<>();
        char upperK = 'A';
        char upperV = 'Z';
        char lowerK = 'a';
        char lowerV = 'z';

        for(int i=0; i<26; i++){
            dictionary.put((char)(upperK+i),(char)(upperV-i));
            dictionary.put((char)(lowerK+i),(char)(lowerV-i));
        }
        return dictionary;
    }

    public void changeChar(StringBuilder answer, HashMap<Character, Character> dictionary, char c){
        if(Character.isAlphabetic(c)){
            answer.append(dictionary.get(c));
            return;
        }
        answer.append(c);
    }

    public static String solution(String word) {
        Problem4 T = new Problem4();
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Character> dictionary = T.makeDictionary();
        for(char c : word.toCharArray()){
            T.changeChar(answer, dictionary, c);
        }
        return answer.toString();
    }
}
