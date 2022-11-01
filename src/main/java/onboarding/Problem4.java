package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = reverse(word);
        return answer;
    }

    public static String reverse(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if(c >= 65 && c <= 90) {
                //대문자
                c += 25 - (c - 65) * 2;
            } else if(c >= 97 && c <= 122) {
                //소문자
                c += 25 - (c - 97) * 2;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
