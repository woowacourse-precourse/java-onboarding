package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lowerCase = "abcdefghijklmnopqrstuvwxyz";

    public static String solution(String word) {

        HashMap<Character, Character> frogMap = new HashMap<>();

        for (int i = 0; i < upperCase.length() - 1; i += 1) {
            frogMap.put(upperCase.charAt(i), upperCase.charAt(upperCase.length() - 1 - i));
            frogMap.put(lowerCase.charAt(i), lowerCase.charAt(lowerCase.length() - 1 - i));
        }

        String answer = getWordTranslation(word, frogMap);

        return answer;
    }

    public static String getWordTranslation(String word, HashMap<Character, Character> frogMap){
        String answer = "";
        for (char c : word.toCharArray()) {
            if (c == ' ') {
                answer += ' ';
                continue;
            }
            answer += frogMap.get(c);
        }
        return answer;
    }

}
