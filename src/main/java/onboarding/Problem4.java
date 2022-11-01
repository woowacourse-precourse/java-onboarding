package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        HashMap alpha = new HashMap<>();

        for (int i = 0; i <= 25; i++) {
            alpha.put((char) ('A' + i), (char) ('Z' - i));
        }


        char[] givenWords = word.toCharArray();

        for (int i = 0; i < givenWords.length; i++) {
            if (givenWords[i] == ' ') {
                continue;
            }
            char current = Character.toUpperCase(givenWords[i]);
            if (Character.isLowerCase(givenWords[i])) {

                givenWords[i] = Character.toLowerCase((char) alpha.get(current));
            } else {
                givenWords[i] = ((char) alpha.get(current));
            }
        }

        String answer = new String(givenWords);

        return answer;
    }

}
