package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static HashMap<Character,Character> dic = new HashMap<>();

    public static String solution(String word) {
        String answer = "";

        makeDictionary();

        return answer;
    }

    public static void makeDictionary(){
        for(int i=0;i<26;i++){
            dic.put((char)(i+'a'),(char)('z'-i));
            dic.put((char)(i+'A'),(char)('Z'-i));
        }
    }
}
