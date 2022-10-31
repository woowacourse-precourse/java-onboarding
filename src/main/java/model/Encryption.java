package model;

import java.util.regex.Pattern;

public class Encryption {
    private String cryptogram;
    private String decryptedText;
    private static final String CONTINUERS = "(\\w)\\1";

    public Encryption(String cryptogram) {
        this.cryptogram = cryptogram;
        this.decryptedText = cryptogram;
        decryption();
    }

    void decryption() {
        while (isContinueChar()) {
            deleteContinueChar();
        }
    }

    void deleteContinueChar() {
        String stringTest = this.decryptedText;
        setDecryptedText(stringTest.replaceAll(CONTINUERS, ""));
    }

    boolean isContinueChar() {
        Pattern pattern = Pattern.compile(CONTINUERS);
        return pattern.matcher(this.decryptedText).find();
    }

    void setDecryptedText(String data) {
        this.decryptedText = data;
    }

    public String getDecryptedText(){
        return this.decryptedText;
    }

}
