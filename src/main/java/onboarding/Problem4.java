package onboarding;

import onboarding.problem4.CharacterConverter;
import onboarding.problem4.WordConverter;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isSpaceChar;

public class Problem4 {
    public static String solution(String word) {
        validateWord(word);

        WordConverter wordConverter = new WordConverter(new CharacterConverter());
        return wordConverter.reverseWord(word);
    }

    private static void validateWord(String word) {
        if (!isValidLength(word)) {
            throw new IllegalArgumentException("1글자 이상 1000글자 이하로 입력 해주세요.");
        }

        if (!containsOnlyAlphabet(word)) {
            throw new IllegalArgumentException("알파벳만 입력 해주세요.");
        }
    }

    private static boolean isValidLength(String word) {  // 길이 체크
        int length = word.length();
        final int MIN_VALUE = 1;
        final int MAX_VALUE = 1_000;

        return MIN_VALUE <= length && length <= MAX_VALUE;
    }

    private static boolean containsOnlyAlphabet(String word) {  // 알파벳 체크
        char[] chars = word.toCharArray();

        for (char aChar : chars) {
            if (!isAlphabetic(aChar) && !isSpaceChar(aChar)) {
                return false;
            }
        }

        return true;
    }
}
