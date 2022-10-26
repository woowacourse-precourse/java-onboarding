package onboarding;

import java.util.StringTokenizer;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder(word);
        for (int i =0; i < sb.length(); i++){
            if (Character.isUpperCase(sb.charAt(i))){
                sb.setCharAt(i, (char)(90 - (sb.charAt(i) - 65)));
            }else if (Character.isLowerCase(sb.charAt(i))){
                sb.setCharAt(i, (char)(122 - (sb.charAt(i) - 97)));
            }
        }

        answer = sb.toString();
        return answer;
    }
}
