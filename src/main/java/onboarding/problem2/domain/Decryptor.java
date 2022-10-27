package onboarding.problem2.domain;

public class Decryptor {
    private Cryptogram cryptogram;
    
    public Decryptor(final String cryptogram) {
        this(new Cryptogram(cryptogram));
    }
    
    public Decryptor(final Cryptogram cryptogram) {
        this.cryptogram = cryptogram;
    }
    
    public Cryptogram decrypt() {
        final Cryptogram decryptedCryptogram = cryptogram.decrypt();
        if (cryptogram.equals(decryptedCryptogram)) {
            return cryptogram;
        }
    
        cryptogram = decryptedCryptogram;
        return decrypt();
    }
}
