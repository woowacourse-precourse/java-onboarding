package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}

class Cryptogram {
    private static final int CRYPTOGRAM_MIN_LENGTH = 1;
    private static final int CRYPTOGRAM_MAX_LENGTH = 1000;
    private static final String NOT_ALLOWED_CRYPTOGRAM_UNDER_MIN_LENGTH = "암호문은 최소 1글자입니다.";
    private static final String NOT_ALLOWED_CRYPTOGRAM_OVER_MAX_LENGTH = "암호문은 최대 1000글자입니다.";
    private static final String ONLY_ALLOWED_CRYPTOGRAM_LOWER_CASE = "암호문은 소문자로만 이루어져 있어야 합니다.";
    private final String cryptogram;

    public Cryptogram(String cryptogram) {
        validateCryptogramLength(cryptogram);
        validateCryptogramLowerCase(cryptogram);
        this.cryptogram = cryptogram;
    }

    private void validateCryptogramLength(String cryptogram) {
        if (cryptogram.length() < CRYPTOGRAM_MIN_LENGTH) {
            throw new IllegalStateException(NOT_ALLOWED_CRYPTOGRAM_UNDER_MIN_LENGTH);
        }
        if (cryptogram.length() > CRYPTOGRAM_MAX_LENGTH) {
            throw new IllegalStateException(NOT_ALLOWED_CRYPTOGRAM_OVER_MAX_LENGTH);
        }
    }

    public void validateCryptogramLowerCase(String cryptogram) {
        if (cryptogram != cryptogram.toLowerCase()) {
            throw new IllegalStateException(ONLY_ALLOWED_CRYPTOGRAM_LOWER_CASE);
        }
    }
}
