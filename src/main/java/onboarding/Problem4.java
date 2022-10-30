package onboarding;

import java.util.Arrays;

public class Problem4 {

    private static char[] lowerChars = new char[26];
    private static char[] upperChars = new char[26];
    public static String solution(String word) {
        String answer = "";
        filllowerAndUpper(word);
        return answer;
    }

    private static void filllowerAndUpper(String word) {

        for (int i = 90; i >= 65; i--) {
            upperChars[90 - i] = (char) i;
        }

        for (int i = 122; i >= 97; i--) {
            lowerChars[122 - i] = (char) i;
        }
    }


}
