package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Map<Character, Character> alphabets = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphabets.put( (char)(i + 'a'), (char)('z' - i));
        }
        char[] chars = word.toCharArray();
        for (char c : chars) {
            answer += Character.toString(changeFrogWord(alphabets, c));
        }
        return answer;
    }
    static char changeFrogWord(Map<Character, Character> map, char ch){
        if(map.containsKey(ch)){
            return map.get(ch);
        }
        return ch;
    }
}