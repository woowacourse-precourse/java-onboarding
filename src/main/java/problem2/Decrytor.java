package problem2;

public class Decrytor {
    private String cryptogram;

    public Decrytor(String cryptogram) {
        this.cryptogram = cryptogram;
        Validator validator = new Validator(cryptogram);
        validator.validate();
    }

    public String decrypt() {
        boolean completeDecrypt = true;
        StringBuilder tempCryptogram = new StringBuilder();

        while(completeDecrypt) {
            getCryptogram(tempCryptogram);
            completeDecrypt = checkCompleteDecrypt(tempCryptogram);
            cryptogram = String.valueOf(tempCryptogram);
            tempCryptogram.setLength(0);
        }
        return cryptogram;
    }

    private boolean checkCompleteDecrypt(StringBuilder tempCryptogram) {
        return cryptogram.length() != tempCryptogram.length();
    }

    private void getCryptogram(StringBuilder tempCryptogram) {
        for(int i = 0; i < cryptogram.length(); i++) {
            updateCryptogram(tempCryptogram, i);
        }
    }

    private void updateCryptogram(StringBuilder tempCryptogram, int index) {
        if(isUnDuplicate(index)) {
            char currentChar = cryptogram.charAt(index);
            tempCryptogram.append(currentChar);
        }
    }

    private boolean isUnDuplicate(int index) {
        return isUnDuplicatePreviousChar(index) && isUnDuplicateNextChar(index);
    }

    private boolean isUnDuplicatePreviousChar(int index) {
        if(index == 0) {
            return true;
        }
        char previousChar = cryptogram.charAt(index-1);
        char currentChar = cryptogram.charAt(index);

        return previousChar != currentChar;
    }

    private boolean isUnDuplicateNextChar(int index) {
        if(index == cryptogram.length()-1) {
            return true;
        }
        char currentChar = cryptogram.charAt(index);
        char nextChar = cryptogram.charAt(index+1);

        return currentChar != nextChar;
    }
}
