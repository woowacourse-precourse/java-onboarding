package onboarding;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        check1(word);
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
        for (int i = 0; i < result1.length; i++) {
            answer += (char)result1[i];

        }

        return answer;

    }
    public static void check1(String word) throws IllegalArgumentException{
        if (word.length() < 1 || word.length() > 1000) {
            throw new IllegalArgumentException("word의 길이가 0이거나 1000을 초과하였습니다.");
        }

    }



}
