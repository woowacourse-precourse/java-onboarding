package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        // 2. word를 탐색하며 문자 변형
        for (char x : word.toCharArray()) {
            answer.append(change(x));
        }
        return answer.toString();
    }
    // 1. 소문자, 대문자 경우에 따른 변형값 생성
   public static String change(char w) {
        int num = (int) w;
       if (w == ' ') {
           return " ";
       }
        if (num >= (int) 'p') {
             return String.valueOf((char) ((int) 'l' - (num - (int) 'o')));
        } else if(num >= (int) 'a'){
           return String.valueOf((char) ((int) 'z' - (num - (int) 'a')));
        } else if (num >= (int) 'P') {
            return String.valueOf((char) ((int) 'L' - (num - (int) 'O')));
        } else {
            return String.valueOf((char) ((int) 'Z' - (num - (int) 'A')));
        }
    }
}
