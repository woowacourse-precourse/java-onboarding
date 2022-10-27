package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static boolean checkAlphabet(char character) {
        if(character < 65 || character > 90 || character < 97 || character > 122) {
           return false;
        }
        return true;
    }

    public static char changeLowercaseLetter(char c) {
        int TOTAL = (int)'a' + (int)'z';
        int asciiNum = (int)c;
        char answer = (char)(TOTAL - asciiNum);
        return answer;
    }


}
