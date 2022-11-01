package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String copy = cryptogram;
        for (int src = 0; src < cryptogram.length() - 1; src++) {
            int dst = getDuplicatedIdxFromSrc(cryptogram, src);
            if (src != dst) {
                cryptogram = deleteCharsBtwIdx(cryptogram, src, dst);
            }
        }
        if (cryptogram.equals(copy)) {
            return cryptogram;
        }
        return solution(cryptogram);
    }

    public static int getDuplicatedIdxFromSrc(String string, int src) {
        int dst = src;
        char c = string.charAt(src);
        for (int i = src + 1; i < string.length(); i++) {
            if (c != string.charAt(i)) {
                break;
            }
            dst++;
        }
        return dst;
    }

    public static String deleteCharsBtwIdx(String string, int src, int dst) {
        String prefix = string.substring(0, src);
        String suffix = string.substring(dst+1);
        return prefix + suffix;
    }
}
