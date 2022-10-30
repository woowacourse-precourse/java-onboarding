package onboarding.problem2;

public class Compress {
    public static String compressWord(String cryptogram) {
        if (Validation.check(cryptogram)) {
            while (needToCompress(cryptogram)) {
                cryptogram = compressOnce(cryptogram);
            }
            return cryptogram;
        }
        return Constant.EXCEPTION;
    }

    static final char SENTINEL = '#';
    public static boolean needToCompress(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

    public static String compressOnce(String cryptogram) {
        String newCryptogram = SENTINEL + cryptogram + SENTINEL;
        String result = "";
        for (int i = 1; i < newCryptogram.length() - 1; i++) {
            if (isLeftRightCharDiff(cryptogram, i)) {
                char middleValue = newCryptogram.charAt(i);
                result += middleValue;
            }
        }
        return result;
    }
    public static boolean isLeftRightCharDiff(String cryptogram, int index) {
        int leftVal = cryptogram.charAt(index - 1);
        int middleVal = cryptogram.charAt(index);
        int rightVal = cryptogram.charAt(index + 1);
        if (leftVal != middleVal && middleVal != rightVal) {
            return true;
        }
        return false;
    }
    
}
