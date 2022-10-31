package model;

import java.util.regex.Pattern;

public class Encryption {
    //복호화한 문자열
    private String decryptedText;
    // 동일한 문자가 연속하는지 정규표현식
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

    //연속된 문자 삭제
    void deleteContinueChar() {
        String stringTest = this.decryptedText;
        setDecryptedText(stringTest.replaceAll(CONTINUERS, ""));
    }

    // 현재의 문자열에 연속된 문자가 있는지 판별하는 함수
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
