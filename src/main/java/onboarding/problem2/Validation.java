package onboarding.problem2;

public class Validation {
    private static final int MAX_LENGTH = 1000;
    private static final int MIN_LENGTH = 1;
    private static final String LENGTH_EXCEPTION_MESSAGE = "문자열의 길이가 범위 밖에 있습니다.";

    private static void validateNotInRange(String cryptogram) {
        if ((cryptogram.length() < MIN_LENGTH) || (cryptogram.length() > MAX_LENGTH)) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
