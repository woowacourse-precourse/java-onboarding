package onboarding;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] alpabet = new char[26];
        char[] reAlpabet = new char[26];

        // 청개구리 배열과, 일반 알파벳 배열을 생성한다.
        for (int i = 0; i < 26; i++) {
            alpabet[i] = (char) ('A' + i);
            reAlpabet[i] =  (char) ('Z'- i);
        }

        System.out.println(Arrays.toString(alpabet));
        System.out.println(Arrays.toString(reAlpabet));


        return answer;
    }
}
