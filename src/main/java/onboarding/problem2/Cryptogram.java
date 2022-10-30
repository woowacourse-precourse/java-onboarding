package onboarding.problem2;

public class Cryptogram {

    private final int MIN_LENGTH = 1;
    private final int MAX_LENGTH = 1000;

    private String cryptogram;

    public Cryptogram(String cryptogram) {
        validateCryptogram(cryptogram);
        this.cryptogram = cryptogram;
    }

    private void validateCryptogram(String cryptogram) {
        if (isOutOfBounds(cryptogram)) throw new IllegalArgumentException("Cryptogram is out of bounds");

        if (!isLowerCase(cryptogram)) throw new IllegalArgumentException("Cryptogram is not lowercase");
    }

    private boolean isOutOfBounds(String cryptogram) {

        int length = cryptogram.length();

        return length > MAX_LENGTH || length < MIN_LENGTH;
    }

}
