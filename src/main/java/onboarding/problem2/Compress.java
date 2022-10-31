package onboarding.problem2;


public class Compress {
    static final char SENTINEL = '#';
    public static boolean needToCompress(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

    public static String compress(String cryptogram) {
        String newCryptogram = SENTINEL + cryptogram + SENTINEL;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < newCryptogram.length() - 1; i++) {
            result.append(getValIfUnique(newCryptogram, i));
        }
        return result.toString();
    }
    public static String getValIfUnique(String cryptogram, int index) {
        if (isLeftRightCharDiff(cryptogram, index)) {
            return cryptogram.substring(index, index+1);
        }
        return "";
    }
    public static boolean isLeftRightCharDiff(String cryptogram, int index) {
        int leftVal = cryptogram.charAt(index - 1);
        int middleVal = cryptogram.charAt(index);
        int rightVal = cryptogram.charAt(index + 1);
        return leftVal != middleVal && middleVal != rightVal;
    }

}
