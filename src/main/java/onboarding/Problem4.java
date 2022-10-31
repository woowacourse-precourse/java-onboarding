package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map<Character, Character> map = new HashMap<>();
        int interval = 0;

        for (int i = 65; i <= 90; i++) {
            map.put((char) i, (char) (90 - interval));
            interval += 1;
        }

        StringBuilder answer = new StringBuilder();
        for (int j = 0; j < word.length(); j++) {
            char temp = word.charAt(j);
            answer.append(getConvertedChar(temp, map));
        }
        return answer.toString();
    }

    public static char getConvertedChar(char c, Map<Character, Character> map) {
        char upperCase = Character.toUpperCase(c);
        if (map.containsKey(upperCase)) {
            Character convertedValue = map.get(upperCase);
            return getLowerOrUpper(c,convertedValue);
        }
        return c;
    }

    private static Character getLowerOrUpper(char c, Character convertedValue) {
        if (Character.isUpperCase(c)) {
            return convertedValue;
        }
        if (Character.isLowerCase(c)) {
            return Character.toLowerCase(convertedValue);
        }
        return c;
    }

}
