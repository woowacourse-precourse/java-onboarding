package onboarding.problem2;

public class Decryptor {
    private String cryptogram;

    public Decryptor(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String getAllRemovedDuplicatedString() {
        String cryptogram = this.cryptogram;
        while (cryptogram != "") {
            String removedDuplicatedString = getRemovedDuplicatedString(cryptogram);
            if (removedDuplicatedString.equals(cryptogram)) {
                return removedDuplicatedString;
            }
            cryptogram = removedDuplicatedString;
        }
        return cryptogram;
    }

    private String getRemovedDuplicatedString(String cryptogram) {
        cryptogram = addBlankAtLastIndex(cryptogram);
        boolean prevDuplicated = false;
        boolean curDuplicated;
        String result = "";

        for (int i = 1; i < cryptogram.length(); i++) {
            char previous = cryptogram.charAt(i - 1);
            char current = cryptogram.charAt(i);
            curDuplicated = isCurDuplicated(previous, current);
            result += getNotDuplicatedChar(curDuplicated, prevDuplicated, previous);
            prevDuplicated = curDuplicated;
        }
        return result;
    }

    private String addBlankAtLastIndex(String cryptogram) {
        return cryptogram + " ";
    }

    private String getNotDuplicatedChar(Boolean curDuplication, Boolean prevDuplication, char previous) {
        if (!curDuplication && !prevDuplication) {
            return String.valueOf(previous);
        }
        return "";
    }

    private boolean isCurDuplicated(char previous, char current) {
        if (current == previous) {
            return true;
        }
        return false;
    }
}
