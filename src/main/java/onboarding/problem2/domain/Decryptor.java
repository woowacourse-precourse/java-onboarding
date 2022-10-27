package onboarding.problem2.domain;

public class Decryptor {
    private Cryptogram cryptogram;
    
    public Decryptor(final String cryptogram) {
        this(new Cryptogram(cryptogram));
    }
    
    public Decryptor(final Cryptogram cryptogram) {
        this.cryptogram = cryptogram;
    }
    
    public boolean decrypte() {
        final Cryptogram removeEqualsTwoCharCryptogram = cryptogram.removeEqualsChar();
        if (cryptogram.equals(removeEqualsTwoCharCryptogram)) {
            return false;
        }
        
        cryptogram = removeEqualsTwoCharCryptogram;
        return decrypte();
    }
    
    public String getCryptogram() {
        return cryptogram.getCryptogram();
    }
}
