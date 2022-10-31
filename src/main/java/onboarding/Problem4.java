package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Map<Character, Character> map = makeMap();

        return answer;
    }

    public static Map<Character,Character> makeMap(){
        Map<Character,Character> hashMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            hashMap.put((char) (i+(int)'A'), (char)((25 - i)+(int)'A'));
        }

        for (int i = 0; i < 26; i++) {
            hashMap.put((char) (i+(int)'a'), (char)((25 - i)+(int)'a'));
        }

        return hashMap;
    }
}
