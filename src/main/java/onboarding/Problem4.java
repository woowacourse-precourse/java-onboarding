package onboarding;

import java.util.HashMap;

public class Problem4 {
    static void createLowerCaseDictionary(HashMap dictionary){
        int n = 25;
        for(int i=97; i<123; i++,n-=2){
            dictionary.put((char)i,(char)(i+n));
        }
    }
    static void createUpperCaseDictionary(HashMap dictionary){
        int n = 25;
        for(int i=65; i<91; i++,n-=2){
            dictionary.put((char)i,(char)(i+n));
        }
    }

    public static String solution(String word) {
        String answer = "";
        HashMap<String,Character> upperDictionary = new HashMap<String, Character>();
        HashMap<String,Character> lowerDictionary = new HashMap<String, Character>();

        return answer;
    }
}
