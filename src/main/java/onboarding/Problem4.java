package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    static HashMap<Character, Character> makeCharacterHash(){
        HashMap<Character, Character> hashMap = new HashMap<>();
        for (char ch = 'A'; ch<='Z'; ch++){
            hashMap.put(ch, (char) ('Z' - ch + 1));
        }
        for (char ch = 'a'; ch<='z'; ch++){
            hashMap.put(ch, (char) ('z' - ch + 1));
        }
        return hashMap;
    }
}
