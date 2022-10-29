package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    static boolean isAlphabet(char w) {
        if(w >= 65 && w <= 90) {
            return true;
        } else if(w >= 97 && w <= 122) {
            return true;
        } else {
            return false;
        }
    }

    public static String solution(String word) {

        String answer = "";

        Map<Character, Character> charMap = new HashMap<>();

        for(int i = 0; i < 26; i++) {
            int asciiKey = i + 97;
            int asciiVal = 122 - i;
            charMap.put((char)asciiKey, (char)asciiVal);
        }

        for(char c : word.toCharArray()) {
            if(isAlphabet(c)) {
                if(Character.isUpperCase(c)) {
                    char lowerAlpha = Character.toLowerCase(c);
                    answer += Character.toUpperCase(charMap.get(lowerAlpha));
                } else {
                    answer += charMap.get(c);
                }
            } else {
                answer += c;
            }
        }

        return answer;
    }

}
