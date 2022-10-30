package onboarding;

import java.sql.Array;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";


        return answer;
    }

    public static int[] changeASCII(String word) {
        int[] wordASCIIArray = new int[word.length()];
        String[] wordArray = word.split("");


        for(int i = 0; i < wordArray.length; i++) {
            wordASCIIArray[i] = Integer.parseInt(wordArray[i]);
        }

        return wordASCIIArray;
    }
}
