package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String plain = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String crypto= "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String answer = "";
        Map<String, String> map = new HashMap<>();
        for (int i=0; i<plain.length();i++){
            map.put(String.valueOf(plain.charAt(i)),String.valueOf(crypto.charAt(i)));
            map.put(String.valueOf(plain.charAt(i)).toLowerCase(),String.valueOf(crypto.charAt(i)).toLowerCase());
        }
        String[] splitStr = word.split("\\s+");
        for(int i = 0;i<splitStr.length;i++){
            for (int a=0; a<splitStr[i].length();a++) {
                answer += map.get(String.valueOf(splitStr[i].charAt(a)));
            }
            answer += " ";
        }
        answer=answer.substring(0,answer.length()-1);
        return answer;
    }
}
