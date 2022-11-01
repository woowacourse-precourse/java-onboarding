package onboarding.problem4;

public class Validation {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 10_000;
    private static final String LENGTH_EXCEPTION_MESSAGE = "문자열의 길이는 1 ~ 10,000여야 합니다.";

    public static void validate(String word) {
        validateInRange(word);
    }

    private static void validateInRange(String word) {
        if ((word.length() < MIN_LENGTH) || (word.length() > MAX_LENGTH)) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
