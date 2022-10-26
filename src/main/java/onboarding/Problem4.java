package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        //아스키 코드 A = 65, Z = 90, a = 97, z = 122
        String answer = "";
        answer = TreeFrog(word);
        return answer;
    }
    public static String TreeFrog(String word){
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            String s = word.substring(i, i+1);
            if (s.equals(" ")) {
                answer += " ";
                continue;
            }

            //소문자, 대문자 체크
            if (Character.isLowerCase(s.charAt(0))) {
                int temp = (int)s.charAt(0)-97;
                answer += (char)(122 - temp);
            } else {
                int temp = (int)s.charAt(0)-65;
                answer += (char)(90 - temp);
            }
        }
        return answer;
    }

}
