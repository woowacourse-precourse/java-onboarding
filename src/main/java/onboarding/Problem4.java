package onboarding;

import static java.lang.Character.isUpperCase;
import static java.util.regex.Pattern.matches;

/**
 * 기능 :
 *  1. 엄마 말씀 word가 매개변수로 주어지면 청개구리 사전을 참고하여 반대로 return
 * 제한 사항 :
 *  1. word의 길이가 1이상 1000이하이다.
 *  2. 알파벳 이외의 문자는 변환하지 않는다.
 *  3. 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
 */
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
