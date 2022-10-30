package onboarding;

import java.sql.Array;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        answer = changeASCIIToWord(reverseWord(changeWordToASCII(word)));

        return answer;
    }

    public static int[] changeWordToASCII(String word) {
        int[] wordASCIIArray = new int[word.length()];
        String[] wordArray = word.split("");

        for(int i = 0; i < wordArray.length; i++) {
            char c = wordArray[i].charAt(0);
            wordASCIIArray[i] = (int) c;
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

    public static String changeASCIIToWord(int[] reversedASCIIArray) {
        char[] reversedWordArray = new char[reversedASCIIArray.length];

        for(int i = 0; i < reversedASCIIArray.length; i++) {
            reversedWordArray[i] = (char)reversedASCIIArray[i];
        }

        String result = new String(reversedWordArray);

        return result;
    }
}
