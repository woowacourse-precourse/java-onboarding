package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        Map<Character, Character> alphabets = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphabets.put( (char)('a' + 'i'), (char)('z' - i));
        }
        char[] chars = word.toCharArray();
        for (char c : chars) {
            answer += Character.toString(changeFrogWord(alphabets, c));
        }
        return answer;
    }
    static char changeFrogWord(Map<Character, Character> map, char ch){
        if (ch >= 'a' && ch <= 'z') {
            return map.get(ch);
        }
        if (ch >= 'A' && ch <= 'Z') {
            return Character.toUpperCase(map.get(Character.toLowerCase(ch)));
        }
        return ch;
    }
}