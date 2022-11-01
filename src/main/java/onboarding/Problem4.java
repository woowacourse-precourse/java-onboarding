package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {

        Map<Character, Character> dictionary = createDictionary();

        word = conversion(dictionary,word);

        return word;
    }

    private static String conversion(Map<Character, Character> dictionary, String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++){
            if(dictionary.get(word.charAt(i)) == null){
                answer += word.charAt(i);
            }else{
                answer += dictionary.get(word.charAt(i));
            }
        }
        return answer;
    }

    public static Map<Character, Character> createDictionary(){

        Map<Character, Character> map = new HashMap<>();

        int idx =0;

        for(int i='A'; i<='Z'; i++ ){
            map.put((char) i,(char)('Z'-idx++));
        }
        idx =0;

        for(int i='a'; i<='z'; i++){
            map.put((char) i,(char)('z'-idx++));
        }
        return map;
    }
}


