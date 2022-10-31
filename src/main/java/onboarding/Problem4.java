package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map<Character, Character> code = new HashMap<>(codeTransform());
        String answer = wordTransform(code, word);
        return answer;
    }

    public static Map<Character, Character> codeTransform() {
        Map<Character, Character> code = new HashMap<>();
        for (int i = 65; i < 91; i++) {
            code.put((char) i, (char) (155 - i));
        }
        for (int i = 97; i < 123; i++) {
            code.put((char) i, (char) (219 - i));
        }
        return code;
    }

    public static String wordTransform(Map<Character, Character> code, String word) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            if ((65 <= word.charAt(i) && word.charAt(i) <= 90) || (97 <= word.charAt(i) && word.charAt(i) <= 122)) {
                result += code.get(word.charAt(i));
            }else{
                result += word.charAt(i);
            }
        }
        return result;
    }
}
