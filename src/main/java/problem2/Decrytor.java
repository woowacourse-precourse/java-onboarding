package problem2;

public class Decrytor {
    private String cryptogram;

    public Decrytor(String cryptogram) {
        this.cryptogram = cryptogram;
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
