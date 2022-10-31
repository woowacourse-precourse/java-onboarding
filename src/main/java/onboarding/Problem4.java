package onboarding;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {

        String alpabet = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String alpabetReverse = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Map testMap = new HashMap();

        for(int i = 0, j = 0 ; i<alpabetReverse.length();i++,j++){
            char a = alpabetReverse.charAt(i);
            char b = alpabet.charAt(j);
            testMap.put(a,b);
        }
        System.out.println(testMap);
        String answer = "";
        return answer;
    }

    public static boolean checkAlpabet(String word) {

        //공백제거
        String onlyAlpabet = word.replaceAll(" ","");

        //알파벳 정규표현식
        String pattern = "^[a-zA-Z]*$";

        return onlyAlpabet.matches(pattern);
    }

    public static String toUpppercase(String word) {
        String result = word.toUpperCase();
        return result;
    }
}
