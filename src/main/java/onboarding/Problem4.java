package onboarding;

import onboarding.problem4.TreeFrogDictionary;

import java.util.regex.Pattern;

public class Problem4 {
    static final int MAX_WORD_LENGTH = 1000;
    static final int MIN_WORD_LENGTH = 1;
    public static String solution(String word) {
        if (!validateWord(word)) {
            return null;
        }
        String answer = TreeFrogDictionary.convertTreeFrogWord(word);
        return answer;
    }

    public static boolean validateWord(String word) {
        if (word.length() < 1 || word.length() > 1000) {
            return false;
        }
        return true;
    }
}
