package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {

        return null;
    }

    private static Map<String,String> createAlphabetMap() {
        Map<String , String > map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            String alpa = Character.toString('a' + i);
            String reverse = Character.toString('z' - i);
            map.put(alpa,reverse);
        }
        return map;
    }

}
