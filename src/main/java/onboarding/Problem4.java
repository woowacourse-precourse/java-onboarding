package onboarding;

import java.util.Map;

public class Problem4 {
    public static void initDictionary(Map<Character, Character> dictionary){
        char upperCase='A';
        char lowerCase='a';

        for (int i = 0; i < 26; i++) {
            dictionary.put((char)(upperCase+i), (char)(upperCase+25-i));
            dictionary.put((char)(lowerCase+i), (char)(lowerCase+25-i));
        }
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
