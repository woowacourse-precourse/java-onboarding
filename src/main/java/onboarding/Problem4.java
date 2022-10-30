package onboarding;

import java.util.Arrays;

public class Problem4 {

    private static char[] upperChars = new char[26];
    private static char[] lowerChars = new char[26];

    public static String solution(String word) {
        String answer = "";
        fillLowerAndUpper();
        return answer;
    }



    private static void fillLowerAndUpper() {

        for (char i = 'a'; i <= 'z'; i++) {
            upperChars[i - 'a'] = i;
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            lowerChars[i - 'A'] = i;
        }
    }


}
