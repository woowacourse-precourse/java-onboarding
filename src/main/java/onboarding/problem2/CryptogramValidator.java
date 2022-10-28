package onboarding.problem2;

import static onboarding.common.CommonMessage.PERMIT_ONLY_LOWERCASE;
import static onboarding.common.CommonValidator.isOnlyContainsLowerCase;

public class CryptogramValidator {

    public static void validateCryptogram(String cryptogram) {
        if (!isValidLength(cryptogram)) {
            throw new IllegalArgumentException("문자의 길이는 1 이상 1,000 이하여야 합니다.");
        }

        if (!isOnlyContainsLowerCase(cryptogram)) {
            throw new IllegalArgumentException(PERMIT_ONLY_LOWERCASE.message());
        }
    }

    private static boolean isValidLength(String cryptogram) {
        final int MAX_VALUE = 1_000;
        final int MIN_VALUE = 1;
        int length = cryptogram.length();

        return MIN_VALUE <= length && length <= MAX_VALUE;
    }
}
