package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        
        String[] change = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"}; 
        Map<String, String> match = new HashMap<>();
        for (int i = 0; i < change.length; i++) {
            match.put(Character.toString('A' + i), change[i]);  
        }

        String[] wordArr = word.split("");
        for (String c : wordArr) {  
            String reverse = match.get(c.toUpperCase());
            if (reverse == null) {
                reverse = " ";
            }
            if (!(Character.isUpperCase(c.charAt(0)))) {
                reverse = reverse.toLowerCase();
            }
            answer += reverse;
        }
        return answer;
    }
}
