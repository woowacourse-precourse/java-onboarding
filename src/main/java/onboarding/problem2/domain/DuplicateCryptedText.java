package onboarding.problem2.domain;

public class DuplicateCryptedText {
    private String cipherText;
    private String decryptedText = null;

    public DuplicateCryptedText(String cipherText){
        this.cipherText = cipherText;
    }

    public void setDecryptedText(String decryptedText){
        this.decryptedText = decryptedText;
    }

    public String getDecryptedText(){
        return this.decryptedText;
    }

}
