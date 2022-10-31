package onboarding;
import java.util.HashMap;
public class Problem4 {
    static char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    static HashMap<Character,Character> map = new HashMap<Character,Character>() {{
        // Upper to Upper
        for(int i = 0; i < alphabets.length; i++) {
            put(alphabets[i], alphabets[25-i]);
        };
        // Lower to Lower
        for(int i = 0; i < alphabets.length; i++) {
            put(Character.toLowerCase(alphabets[i]), Character.toLowerCase(alphabets[25-i]));
        };
    }};

    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++) {
            if (map.containsKey(word.charAt(i))) {
                answer += map.get(word.charAt(i));
            } else {
                answer += word.charAt(i);
            }
        }
        return answer;
    }
}
