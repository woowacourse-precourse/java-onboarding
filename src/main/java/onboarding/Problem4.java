package onboarding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class Problem4 {
    public static Character conversion(Character c){
        int temp = 0;
        if (isUpperCase(c)){
            temp = (int)'Z' - ((int)c -(int)'A');

        } else if (isLowerCase(c)) {
            temp = (int)'z' - ((int)c -(int)'a');
        }
        return (char)temp;
    }
    public static String solution(String word) {
        String answer = "";

        for (int i =0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!Character.isAlphabetic(c)){
                answer += c;
                continue;
            }
            answer += conversion(c);

        }
        return answer;
    }
}

// 체크사항
// 1. 아스키코드 사용 25차이
// 2. String to Char
// 3. 예외처리 isAlphabetic