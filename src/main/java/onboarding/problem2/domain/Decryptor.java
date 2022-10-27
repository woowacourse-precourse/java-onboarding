package onboarding.problem2.domain;

public class Decryptor {
    private final Cryptogram cryptogram;
    
    public Decryptor(final String cryptogram) {
        this(new Cryptogram(cryptogram));
    }
    
    public Decryptor(final Cryptogram cryptogram) {
        this.cryptogram = cryptogram;
    }
    
    public boolean decrypt() {
        if (cryptogram.decrypt()) {
            return decrypt();
        }
        
        return true;
    }
    
    public String getCryptogram() {
        return cryptogram.getCryptogram();
    }
}
