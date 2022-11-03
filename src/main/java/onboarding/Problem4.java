package onboarding;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        char[] word_array = word.toCharArray();

        if(!checkWordLength(word))
            return answer.toString();

        for (char c : word_array) {
            if (c > 64 && c < 91) {
                char tmp = (char) (90 - c + 65);
                answer.append(tmp);
            } else if (c > 96 && c < 123) {
                char tmp = (char) (122 - c + 97);
                answer.append(tmp);
            } else {
                answer.append((char) c);
            }
        }
        return answer.toString();
    }

    public static boolean checkWordLength(String word){
        return word.length()>0 && word.length()<1000;
    }
}
