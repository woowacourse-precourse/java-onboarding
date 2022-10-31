package onboarding;

import java.util.*;

public class Problem4 {
    public static String solution(String word) {

        if(!checkAlpabet(word)) {
            String fail = "NotAlpabet";
            return fail;
        }

        String uppercaseReverse = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String lowercaseReverse = "zyxwvutsrqponmlkjihgfedcba";
        
        String answer ="";
        return answer;
    }

    public static boolean checkAlpabet(String word) {

        //공백제거
        String onlyAlpabet = word.replaceAll(" ","");

        //알파벳 정규표현식
        String pattern = "^[a-zA-Z]*$";

        return onlyAlpabet.matches(pattern);
    }
}
