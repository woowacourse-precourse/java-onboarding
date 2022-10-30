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

    public static int[] reverseWord(int[] wordASCIIArray) {
        for(int i = 0; i < wordASCIIArray.length; i++) {
            if(wordASCIIArray[i] >= 65 && wordASCIIArray[i] <= 90) {
                wordASCIIArray[i] = 155 - wordASCIIArray[i];
            }
            else if(wordASCIIArray[i] >= 97 && wordASCIIArray[i] <= 122) {
                wordASCIIArray[i] = 219 - wordASCIIArray[i];
            }
        }

        return wordASCIIArray;
    }
}
