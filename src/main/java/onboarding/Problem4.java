package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder(word);
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                sb.setCharAt(i,(char) (Math.abs(ch-'z') + 'a'));
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.setCharAt(i,(char) (Math.abs(ch-'Z') + 'A'));
            } else
                continue;
        }
        answer = sb.toString();
        return answer;
    }
}
