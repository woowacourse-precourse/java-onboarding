package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] words = word.toCharArray();

        for(char c : words){
            if('A' <= c && c <= 'Z'){
                answer += (char)(('A'+'Z') - c);
            } else if('a' <= c && c <= 'z'){
                answer += (char)(('a'+'z') - c);
            } else {
                answer += c;
            }
        }
        return answer;
    }
}
