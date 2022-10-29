package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lowerCase = "abcdefghijklmnopqrstuvwxyz";

    public static String solution(String word) {

        HashMap<Character, Character> frogMap = new HashMap<>();

        frogMap = frogMapper(frogMap, upperCase);
        frogMap = frogMapper(frogMap, lowerCase);

        String answer = getWordTranslation(word, frogMap);

        return answer;
    }

    public static HashMap<Character, Character> frogMapper(HashMap<Character, Character> hashmap, String string){
        for (int i = 0; i < string.length() - 1; i += 1) {
            hashmap.put(string.charAt(i), string.charAt(string.length() - 1 - i));
        }
        return hashmap;
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
