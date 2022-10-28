package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static void setValue(HashMap<Character, Character> map){
        int start = 0;
        for(int i = 65; i < 91; i++){
            map.put((char)i, (char)(90 - start));
            start += 1;
        }
        start = 0;
        for(int i = 97; i < 123; i++){
            map.put((char)i, (char)(123 - start));
        }
    }
}
