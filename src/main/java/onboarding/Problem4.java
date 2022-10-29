package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        return answer;
    }

    public static Map<Character,Character> reverseFrog(){
        Map<Character,Character> frogMap = new HashMap<>();
        //A=65 a=97
        int count = 0;
        for(int i=65;i<=90;i++){
            //대문자
            frogMap.put( (char)i ,(char)(i-count) );
            //소문자
            int low = i+32;
            frogMap.put( (char)low, (char)(low-2) );

            count+=2;
        }
        frogMap.put( (char)32, (char)32);
        return frogMap;
    }

    public  static String getAnswer(String word, Map<Character,Character> frogMap){
        char[] wordCh = word.toCharArray();
        StringBuilder st = new StringBuilder();

        for(char c : wordCh) {
            st.append(frogMap.get(c));
        }

        return  st.toString();
    }
}
