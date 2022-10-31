package onboarding;

import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)>=65 && word.charAt(i) <=90){
                int dis = word.charAt(i) - 65;
                answer += (char)  ('A' +25 -dis);

            }else if (word.charAt(i)>=97 && word.charAt(i) <=122){
                int dis = word.charAt(i) - 97;
                answer += (char) ('a'+25 -dis);
            }
            else answer+=word.charAt(i);
        }

        return answer;
    }
}
