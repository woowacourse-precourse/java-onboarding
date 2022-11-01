package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<Character,Character> up_map = new HashMap<>();
        HashMap<Character,Character> low_map = new HashMap<>();

        for(int i=0; i < 26; i++ ){
            int key_alpha = 65 + i;
            int val_alpha = 90 - i;
            char key = (char)key_alpha;
            char val = (char)val_alpha;
            up_map.put(key,val);
        }

        for(int i=0; i < 26; i++ ){
            int key_alpha = 97 + i;
            int val_alpha = 122 - i;
            char key = (char)key_alpha;
            char val = (char)val_alpha;
            low_map.put(key,val);
        }





        return answer;
    }
}
