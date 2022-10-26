package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (isEqualsTwoString(cryptogram.charAt(i), cryptogram.charAt(i + 1))) {
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i + 2);
                
                if (i == 0) {
                    i--;
                } else {
                    i -= 2;
                }
            }
        }
        
        return answer;
    }
    
    private static boolean isEqualsTwoString(final char firstChar, final char secondChar) {
        return firstChar == secondChar;
    }
}
