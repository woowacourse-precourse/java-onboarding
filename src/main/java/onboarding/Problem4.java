package onboarding;

import java.util.Arrays;

public class Problem4 {

    static String[] vocabulary = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static String solution(String word) {
        String answer = transferString(word);
        return answer;
    }

    private static String transferString(String word) {
        String transferString = "";
        String[] transferWord = new String[word.length()];

        for (int i = 0; i < word.length(); i++) {
            char transferChar = word.charAt(i);
            // 대문자인 경우
            if (Character.isUpperCase(transferChar)) {
                transferWord[i] = transferChar(String.valueOf(transferChar)).toUpperCase();
            }
            // 소문자인 경우
            else if (Character.isLowerCase(word.charAt(i))) {
                transferWord[i] = transferChar(String.valueOf(transferChar)).toLowerCase();
            }
        }
        return transferString;
    }

    private static String transferChar(String transferChar) {
        int tIndex = Arrays.asList(vocabulary).indexOf(transferChar);
        return vocabulary[vocabulary.length - 1 - tIndex];
    }
}