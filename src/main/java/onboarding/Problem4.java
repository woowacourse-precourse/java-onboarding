package onboarding;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        int[] result = new int[word.length()];
        int[] result1 = new int[word.length()];

        for (int i = 0; i < word.length(); i++) {
            result[i] = (int)(word.charAt(i));
            if (result[i] >= 65 && result[i] <= 90) {
                result1[i] = 155 - result[i];
            } else if (result[i] >= 97 && result[i] <= 122) {
                result1[i] = 219 - result[i];
            } else if (result[i] == 32) {
                result1[i] = result[i];
            }
        }



        return answer;

    }
