package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        return reverseWord(word);
    }

    private static String reverseWord(String word) {
        Map<String, String> alphabetMap = createAlphabetMap();
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = word.split("");

        for (String alpha : split) {
            if (alphabetMap.containsKey(alpha)) {
                stringBuilder.append(alphabetMap.get(alpha));
                continue;
            }
            stringBuilder.append(alpha);
        }
        return stringBuilder.toString();
    }

    private static Map<String,String> createAlphabetMap() {
        Map<String , String > map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            String lowerAlpha = Character.toString('a' + i);
            String lowerReverse = Character.toString('z' - i);
            String upperAlpha = Character.toString('A' + i);
            String upperReverse = Character.toString('Z' - i);
            map.put(lowerAlpha,lowerReverse);
            map.put(upperAlpha, upperReverse);

        }
        return map;
    }

}
