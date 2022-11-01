package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public char changeAlphabet(char alphabet) {
        if('A' <= alphabet &&  alphabet < 'a') {  // 대문자
             alphabet = (char)('Z' + (char)('A' - alphabet));
        } else {
             alphabet = (char)('z' + (char)('a' - alphabet));
        }

        return alphabet;
    }

    public String greenFlogRule(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if(letter == ' '){
                sb.append(letter);
            } else {
                sb.append(changeAlphabet(letter));
            }
        }
        return sb.toString();
    }


    public static String solution(String word) {
        String answer = "";

        Problem4 main = new Problem4();
        answer = main.greenFlogRule(word);

        return answer;
    }
}
