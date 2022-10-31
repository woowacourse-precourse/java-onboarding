package problem2;

public class Deleter {
    StringBuilder code;
    int codeLength;

    public Deleter(StringBuilder code, int codeLength) {
        this.code = code;
        this.codeLength = codeLength;
    }

    public int getNumberOfDeleted() {
        int deletedLength = 0;

        for (int i = 0; i < codeLength; i++) {
            int lastSameLetterIndex = getLastSameLetterIndex(code, codeLength, i, code.charAt(i));
            int redundantLength = lastSameLetterIndex-i;

            if(redundantLength > 1){
                deletedLength += redundantLength;
                deleteRedundantLetters(i, lastSameLetterIndex, redundantLength);
                i--;
            }
        }

        return deletedLength;
    }

    private void deleteRedundantLetters(int i, int lastSameLetterIndex, int redundantLength) {
        code.delete(i, lastSameLetterIndex);
        codeLength -= redundantLength;
    }

    private static int getLastSameLetterIndex(StringBuilder code, int codeLength, int i, char targetChar) {
        int j = i + 1;
        for (; j < codeLength && code.charAt(j) == targetChar; j++) ;
        return j;
    }
}
