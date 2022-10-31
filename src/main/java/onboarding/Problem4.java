package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        HashMap<Character, String> map = new HashMap<>();
        for(int i = 'A'; i <= 'Z'; i++) {
            map.put((char) i, Character.toString(155 - (char) i));
        }
        for(int i = 'a'; i <= 'z'; i++) {
            map.put((char) i, Character.toString(219 - (char) i));
        }

        String answer = "";
        return answer;
    }
}
