package onboarding;

import java.util.HashMap;

public class Problem4 {
    static HashMap<Character, Character> map = new HashMap<>();
    public static String solution(String word) {
        String answer = "";
        makeDictionary();
        for(int i=0; i<word.length(); i++){
            if (word.charAt(i) == ' ') {
                answer += ' ';
                continue;
            }
            answer += map.get(word.charAt(i));
        }

        return answer;
    }

    private static void makeDictionary() {
        for(char i='A'; i <='Z'; i++){
            map.put(i, (char)('A' + 'Z' - i));
        }
        for(char i = 'a'; i <= 'z'; i++){
            map.put(i, (char) ('a' + 'z' - i));
        }
    }
}
