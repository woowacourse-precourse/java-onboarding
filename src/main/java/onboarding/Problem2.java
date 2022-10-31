package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int i = 0;
        int len;

        while (i < cryptogram.length()) {
            len = cryptogram.length();
            cryptogram = removeContinuousWord(cryptogram, cryptogram.charAt(i), i);
            if (len != cryptogram.length()) {
                i = 0;
            } else {
                ++i;
            }
        }
        return cryptogram;
    }

    private static String removeContinuousWord(String str, char c, int idx) {
        int i = 1;

        while (idx + i < str.length() && str.charAt(idx + i) == c) {
            ++i;
        }
        if (i > 1) {
            return str.substring(0, idx) + str.substring(idx + i);
        }
        return str;
    }
}
