package onboarding;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {

        String answer = "";
        int idx=0;
        char[] alphabet = new char[26];

        for (char i = 'z'; i >= 'a'; i--) {
            alphabet[(int)('z'-i)] =i;
        }

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            if (Character.isLowerCase(c) == true) {

                idx = (int)(c-'a');
                answer+=String.valueOf(alphabet[idx]);
            } else if (Character.isUpperCase(c)==true) {

                idx = (int)(c-'A');
                answer+=String.valueOf(alphabet[idx]).toUpperCase();
            }else{
                answer+=String.valueOf(c);
            }


        }
        System.out.println("answer = " + answer);

        return answer;
    }


}
