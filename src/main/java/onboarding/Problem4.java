package onboarding;

import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] wordArray = word.toCharArray();
        char convertChar;

        for (int i = 0; i<wordArray.length; i++) {
            char c = wordArray[i];
            if (Character.isAlphabetic(c)) {
                if (Character.isLowerCase(c)) {
                    convertChar = (char) ('z' - c + 'a');
                    wordArray[i] = convertChar;

                    System.out.println(c);
                } else if (Character.isUpperCase(c)) {
                    convertChar = (char) ('Z' - c + 'A');
                    wordArray[i] = convertChar;
                }
            } else {
                convertChar = c;
            }

        }
        answer = new String(wordArray);
        return answer;
    }
}
