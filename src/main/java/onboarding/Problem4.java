package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        Map<Character, Character> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put((char)((int)'A'+i), (char)((int)'Z'-i));
        }
        for (int i = 0; i < 26; i++) {
            dict.put((char)((int)'a'+i), (char)((int)'z'-i));
        }

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ' ') answer += " ";
            else if(dict.containsValue(word.charAt(i))){
                answer += dict.get(word.charAt(i));
            }
            else{
                answer += word.charAt(i);
            }
        }

        return answer;
    }
}
