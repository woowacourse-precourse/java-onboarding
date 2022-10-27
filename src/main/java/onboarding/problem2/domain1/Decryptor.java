package onboarding.problem2.domain1;

public class Decryptor {
    private Cryptogram cryptogram;
    
    public Decryptor(final String cryptogram) {
        this(new Cryptogram(cryptogram));
    }
    
    public Decryptor(final Cryptogram cryptogram) {
        this.cryptogram = cryptogram;
    }
    
    public boolean decrypte() {
        final Cryptogram decryptedCryptogram = cryptogram.decrypte();
        if (cryptogram.equals(decryptedCryptogram)) {
            return false;
        }
        
        cryptogram = decryptedCryptogram;
        return decrypte();
    }
    
    public String decryptedCryptogram() {
        return cryptogram.getCryptogram();
    }
    
    @Override
    public String toString() {
        return "Decryptor{" +
                "cryptogram=" + cryptogram +
                '}';
    }
}
