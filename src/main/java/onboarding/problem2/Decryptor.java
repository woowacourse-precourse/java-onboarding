package onboarding.problem2;

import java.util.Stack;

public class Decryptor {
    String cryptogram;
    StringBuilder decryptor;

    public Decryptor(String cryptogram) {
        this.cryptogram = cryptogram;
        decryptor = new StringBuilder();
    }

    public String result() {
        String decodedCryptogram;
        while (true) {
            decryptor = new StringBuilder();
            decodedCryptogram = decode();
            if(cryptogram.equals(decodedCryptogram)) break;
            cryptogram = decodedCryptogram;
        }
        return cryptogram;
    }

    private String decode() {
        boolean isDuplicated = false;

        for (int idx = 0; idx < cryptogram.length(); idx++) {
            char nextCharacter = cryptogram.charAt(idx);

            if (isDecryptorEmptyThenPush(nextCharacter)) continue;
            if (isDuplicateCharacter(nextCharacter)) {
                isDuplicated = true;
                continue;
            }
            if (isDuplicated) {
                decryptor.deleteCharAt(decryptor.length()-1);
                isDuplicated=false;
            }
            decryptor.append(nextCharacter);
        }
        if(isDuplicated) decryptor.deleteCharAt(decryptor.length() - 1);
        return decryptor.toString();
    }

    private boolean isDecryptorEmptyThenPush(char nextCharacter) {
        if (decryptor.length()==0) {
            decryptor.append(nextCharacter);
            return true;
        }
        return false;
    }

    private boolean isDuplicateCharacter(char next) {
        if (decryptor.charAt(decryptor.length()-1) == next) {
            return true;
        }
        return false;
    }
}
