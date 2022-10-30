package onboarding;

import static java.lang.Character.isUpperCase;
import static java.util.regex.Pattern.matches;

public class Problem4 {
    private static final String EXCEPTION = "word length error";

    public static String solution(String word) {
        return restrictions(word) ? EXCEPTION : reverse(word);
    }

    private static boolean restrictions(String word) {
        return word.length() < 1 || word.length() > 1000;
    }

    private static String reverse(String word) {
        char[] chars = word.toCharArray();
        StringBuilder answer = new StringBuilder();
        for (char c : chars) {
            answer.append(isAlphabet(c) ? treeFrogDictionary(c) : c);
        }
        return answer.toString();
    }

    private static boolean isAlphabet(char c) {
        return matches("[a-zA-Z]", String.valueOf(c));
    }

    private static char treeFrogDictionary(char chr) {
        char start = isUpperCase(chr) ? 'A' : 'a';
        char end = isUpperCase(chr) ? 'Z' : 'z';
        return (char) (start + (end - chr));
    }
}
