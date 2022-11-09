package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map map = new HashMap();
        map.put(32, 32);
        for (int i = 65; i < 91; i++) {
            map.put(i, 155 - i);
        }
        for (int j = 97; j < 123; j++) {
            map.put(j, 219 - j);
        }

        String newword = "";
        for (int a = 0; a < word.length(); a++) {
            int newcharint  = (int)map.get((int)word.charAt(a));
            newword += (char) newcharint;
        }

        return newword;
    }
}
