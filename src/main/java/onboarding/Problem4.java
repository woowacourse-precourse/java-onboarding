package onboarding;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class Problem4 {
    private static final int UPPERCASE_NUMBER = 155;
    private static final int LOWERCASE_NUMBER = 219;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    public static String solution(String word) {
        validityChecker(word);

        return modifyString(word);
    }

    private static void validityChecker(String word) {
        if (isNotValidWord(word)) {
            throw new IllegalArgumentException("Not valid word");
        }
    }
    private static boolean isNotValidWord(String word) {
        return word.length() < MIN_LENGTH || MAX_LENGTH < word.length();
    }
    private static String modifyString(String word) {
        char[] resultWord = word.toCharArray();
        for (int i = 0; i < resultWord.length; i++) {
            resultWord[i] = modifychar(resultWord[i]);
        }
        return String.valueOf(resultWord);
    }
    private static char modifychar(char ch) {
        if (isUpperCase(ch)) {
            return (char)(UPPERCASE_NUMBER - ch);

        }
        else if (isLowerCase(ch)) {
            return (char)(LOWERCASE_NUMBER - ch);
        }
        return (ch);
    }
}