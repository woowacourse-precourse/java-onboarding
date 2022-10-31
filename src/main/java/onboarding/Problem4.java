package onboarding;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        answer = chage(word);

        return answer;
    }

    // ( '0' = 48, 'A' ~ 'Z' = 65 ~ 90, 'a' ~ 'z' = 97 ~ 122)
   public static String chage(String word){
       HashMap<Character, Character> map1 = new HashMap<>();
       StringBuilder b = new StringBuilder();
       char [] lowChar = new char[26];
       char [] upperChar = new char[26];

       for(int i = 0; i<lowChar.length; i++){
           lowChar[i] = (char)(97+i);

       }
       for(int i = 0; i<upperChar.length; i++){
           upperChar[i] = (char)(65+i);
       }



   }
}
