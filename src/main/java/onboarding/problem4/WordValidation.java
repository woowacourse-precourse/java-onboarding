package onboarding.problem4;

public class WordValidation {

    public static void validateWord(String word) {
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
        }

        return word.matches("^[a-zA-Z]*$");
    }
}
