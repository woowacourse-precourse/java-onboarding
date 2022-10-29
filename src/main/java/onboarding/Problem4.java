package onboarding;

public class Problem4 {
    public static final int MAX_WORD_LENGTH = 1000;

    public static String solution(String word) {
        try {
            validateLength(word);
        } catch (IllegalArgumentException e) {
            return e.toString();
        }
    }

    public static void validateLength(String word) {
        if (word.length() < 1 || word.length() > MAX_WORD_LENGTH) {
            throw new IllegalArgumentException("허용되지 않은 길이의 문자열입니다.");
        }
    }
}
