package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        String[] words = word.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = changeStr(words[i]);
        }
        String answer = String.join(" ", words);
        return answer;
    }
    static String changeStr(String str){
        char[] xs = str.toCharArray();

        for (int i = 0; i < xs.length; i++) {

            if('a' <= xs[i] && xs[i] <= 'z'){
                xs[i] = (char)('a' + 'z' - xs[i]);
            }
            else if ('A' <= xs[i] && xs[i] <= 'Z') {
                xs[i] = (char)('A' + 'Z' - xs[i]);
            }
        }
        return new String(xs);
    }
}
