package model;

import java.util.regex.Pattern;

public class Encryption {
    private String decryptedText;
    private static final String CONTINUERS = "(\\w)\\1";

    public Encryption(String cryptogram) {
        this.decryptedText = cryptogram;
        decryption();
    }

    //복호화
    void decryption() {
        while (isContinueChar()) {
            deleteContinueChar();
        }
    }

    void deleteContinueChar() {
        String stringTest = this.decryptedText;
        setDecryptedText(stringTest.replaceAll(CONTINUERS, ""));
    }

    // 현재의 문자열에 연속된 문자가 있는지 판별하는 메소드
    boolean isContinueChar() {
        Pattern pattern = Pattern.compile(CONTINUERS);
        return pattern.matcher(this.decryptedText).find();
    }

    void setDecryptedText(String data) {
        this.decryptedText = data;
    }

    public String getDecryptedText() {
        return this.decryptedText;
    }

}
