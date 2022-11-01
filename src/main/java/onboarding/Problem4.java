package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = changeWord(word);
        return answer;
    }

    //알파벳을 바꾸는 기능
    //대문자 소문자 구분해서 바꾸는 기능

    public static String changeWord(String word){
        String[] split = word.split("");
        List<String> sol = new ArrayList<>();
        char c;

        for (String s : split) {
            int i = (int) s.toCharArray()[0];
            if(i>=97 && i<=122){
                c=(char)(122-(i-97));
            }else if(i>=65 && i<=90){
                c=(char)(90-(i-65));
            }else{
                c=(char)i;
            }
            sol.add(String.valueOf(c));
        }
        return String.join("",sol);
    }
}
