package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String upper_alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String result = "";
        for(int i=0; i<word.length();i++){
            int j = word.charAt(i);
            if (j==32) result += " ";
            else if (65<=j && j<=90) result += (upper_alpha.charAt((155-j)-65));
            else if(97<=j && j <= 122) result += alpha.charAt((219-j)-97);

        }

        return result;
    }
}
