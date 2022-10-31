package onboarding.problem2;

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
        if (cryptogram.length() == 0 || cryptogram.length() >= 1001) {
            throw new IllegalArgumentException();
        }
    }

    private void isOnlySmallCase(String cryptogram) {
        if (!cryptogram.toLowerCase().equals(cryptogram)) {
            throw new IllegalArgumentException();
        }
    }

    public StringBuilder getBuilder() {
        return new StringBuilder(cryptogram);
    }
}
