package onboarding.problem2;

import static onboarding.problem2.ConstantsP2.CIPHER_MAX_LENGTH;
import static onboarding.problem2.ConstantsP2.CIPHER_MIN_LENGTH;
import static onboarding.problem2.ConstantsP2.INPUT_PATTERN;

public class Cipher {
    private final String cryptogram;

    public Cipher(String cryptogram) {
        isIllegal(cryptogram);
        this.cryptogram = cryptogram;
    }

    private void isIllegal(String cryptogram) {
        isNotNull(cryptogram);
        isInRange(cryptogram);
        isOnlySmallCase(cryptogram);
    }

    private void isNotNull(String cryptogram) {
        if (cryptogram == null) {
            throw new IllegalArgumentException();
        }
    }

    private void isInRange(String cryptogram) {
        if (cryptogram.length() < CIPHER_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (cryptogram.length() > CIPHER_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void isOnlySmallCase(String cryptogram) {
        if (!INPUT_PATTERN.matcher(cryptogram).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public StringBuilder getBuilder() {
        return new StringBuilder(cryptogram);
    }
}
