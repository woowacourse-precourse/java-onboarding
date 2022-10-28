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
            char leftValue = newCryptogram.charAt(i-1);
            char middleValue = newCryptogram.charAt(i);
            char rightValue = newCryptogram.charAt(i+1);

            if (leftValue != middleValue && middleValue != rightValue) {
                result += middleValue;
            }
        }
        return result;
    }
}
