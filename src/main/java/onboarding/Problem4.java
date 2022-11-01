package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static HashMap<Character,Character> dic = new HashMap<>();

    public static String solution(String word) {
        String answer = "";

        makeDictionary();

        for(int i=0;i<word.length();i++){
            answer+=convert(word.charAt(i));
        }

        return answer;
    }

    public static Character convert(Character word){
        Character converted = dic.get(word);
        if(converted == null){
            return word;
        }
        return converted;
    }


    public static void makeDictionary(){
        for(int i=0;i<26;i++){
            dic.put((char)(i+'a'),(char)('z'-i));
            dic.put((char)(i+'A'),(char)('Z'-i));
        }
    }
}
