package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {

        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < 27; i++){
            map.put((char) ('a' + i), (char) ('z' - i));
            map.put((char) ('A' + i), (char) ('Z' - i));
        }

        String answer = "";
        for(int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            answer += map.getOrDefault(c, c);
        }

        return answer;
    }
}
