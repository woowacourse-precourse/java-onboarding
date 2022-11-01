package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    private static char getUpperTrans(int n){
        // 90-(n-65)
        int transNum = 155-n;
        return (char) transNum;
    }

    private static char getLowerTrans(int n){
        // 112-(n-97)
        int transNum = 219-n;
        return (char) transNum;
    }
    public static String solution(String word) {
        String answer = "";

        for (char ch: word.toCharArray()) {
            int chInt = ch;
            if (65<=chInt && chInt<=90){
                answer += Character.toString(getUpperTrans(ch));
            }else if(97<=chInt && chInt<=122){
                answer += Character.toString(getLowerTrans(ch));
            }else{
                answer += Character.toString(ch);
            }
        }

        return answer;
    }
}
