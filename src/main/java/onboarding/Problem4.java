package onboarding;

import java.util.Arrays;

public class Problem4 {

    private static char[] upperChars = new char[26];
    private static char[] lowerChars = new char[26];

    public static String solution(String word) {
        String answer = "";
        fillLowerAndUpper();
        answer = checkWord(word);
        return answer;
    }

    private static String checkWord(String word) {
        char[] chars = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < upperChars.length; j++) {
                if (word.charAt(i) == upperChars[j]) {
                    chars[i] = upperChars[(upperChars.length - 1) - j];
                } else if (word.charAt(i) == lowerChars[j]) {
                    chars[i] = lowerChars[(upperChars.length - 1) - j];
                } else if (word.charAt(i) == ' ') {
                    chars[i] = ' ';
                }
            }

        }


        return new String(chars);
    }


    private static void fillLowerAndUpper() {

        for (char i = 'a'; i <= 'z'; i++) {
            upperChars[i - 'a'] = i;
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            lowerChars[i - 'A'] = i;
        }
    }


}
