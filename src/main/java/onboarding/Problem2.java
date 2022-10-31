package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer="";
        if (cryptogram.length() == 0) {
            return "";
        }

        char[] chars = cryptogram.toCharArray();

        int i, k = 0;

        for (i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                chars[k++] = chars[i - 1];
            } else {
                while (i < chars.length && chars[i - 1] == chars[i]) {
                    i++;
                }
            }
        }
        if(k!=0) {
            chars[k++] = chars[i - 1];

            answer = new String(chars).substring(0, k);

            if (k != chars.length) {
                return solution(answer);
            }
        }else {
            answer = "";
        }
        return answer;
    }
}
