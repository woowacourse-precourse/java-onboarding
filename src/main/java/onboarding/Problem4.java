package onboarding;

import java.util.HashMap;

public class Problem4 {
    private static HashMap<Character, Character> frogDictionary;
    private static String matchStr="ZYXWVUTSRQPONMLKJIHGFEDCBA";
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    private static void createFrogDictionary(){
        for (int i=65; i<91;i++){
            frogDictionary.put((char)i, matchStr.charAt(i-65));
        }
        for (int i=97; i<123;i++){
            frogDictionary.put((char)i, matchStr.charAt(i-97));
        }
    }
}
