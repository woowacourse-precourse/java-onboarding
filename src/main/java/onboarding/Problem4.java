package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String frog(String word){
        String res = "";
        for(int i = 0; i < word.length(); i++){
            int num = (int)word.charAt(i);
            int target = 0;
            if(num >= 65 and num <= 90){
                target = 155 - num;
                res += (char)target;
            }
            else if(num >= 97 and num <= 122){
                target = 219 - num;
                res += (char)target;
            }
            else{
                res += word.charAt(i);
            }
        }
        return res;
    }
    public static String solution(String word) {
        String answer = frog(word);
        return answer;
    }
}
