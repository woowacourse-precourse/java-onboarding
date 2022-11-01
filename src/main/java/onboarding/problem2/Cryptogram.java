package onboarding.problem2;

public class Cryptogram {

    private final int MIN_LENGTH = 1;
    private final int MAX_LENGTH = 1000;

    private String cryptogram;
    private String decrypted;

    public Cryptogram(String cryptogram) {
        validateCryptogram(cryptogram);
        this.cryptogram = cryptogram;
        this.decrypted = cryptogram;
    }

    private void validateCryptogram(String cryptogram) {
        if (isOutOfBounds(cryptogram)) throw new IllegalArgumentException("Cryptogram is out of bounds");

        if (!isLowerCase(cryptogram)) throw new IllegalArgumentException("Cryptogram is not lowercase");
    }

    private boolean isOutOfBounds(String cryptogram) {

        int length = cryptogram.length();

        return length > MAX_LENGTH || length < MIN_LENGTH;
    }

    private boolean isLowerCase(String cryptogram) {
        return cryptogram.chars()
                .filter(Character::isUpperCase)
                .findAny()
                .isEmpty();
    }

    private String removeDuplicateCharacter() {
        String regex = "(([a-z])\\2+)";
        return this.decrypted.replaceAll(regex, "");
    }

    public String decipher() {

        String temp = removeDuplicateCharacter();

        while (decrypted.length() != temp.length()) {
            decrypted = temp;
            temp = removeDuplicateCharacter();
        }

        return decrypted;
    }
}
