package onboarding;

import java.util.ArrayList;

public class Problem4 {
    private static char convertToReverse(char chr){
        if ('a' <= chr && chr <= 'z')
            return (char)('z' - chr + 'a');
        if ('A' <= chr && chr <= 'Z')
            return (char)('Z' - chr + 'A');
        return chr;
    }
    public static String solution(String word) {
        StringBuilder   answer = new StringBuilder();
        char[] wordToArray = word.toCharArray();
        int             i;
        char            chr;

        for(i = 0; i < word.length(); i++){
            chr = convertToReverse(wordToArray[i]);
            answer.append(chr);
        }
        return answer.toString();
    }
}
