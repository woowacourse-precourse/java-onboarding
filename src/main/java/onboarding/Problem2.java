package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decode(cryptogram);
    }

    static int hasDuplicate(int start, String str) {
        for (int i = start; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                return i;
        }
        return -1;
    }

    static String decode(String cryptogram) {
        int start = hasDuplicate(0, cryptogram);
        if (start == -1) return cryptogram;

        int end = start + 1;
        while (end < cryptogram.length()) {
            if (start == -1) break;
            if (cryptogram.charAt(end) != cryptogram.charAt(start) || end == cryptogram.length() - 1) {
                cryptogram = cryptogram.replace(cryptogram.substring(start, end), "");
                start = hasDuplicate(start, cryptogram);
                end = start;
            }
            end++;
        }
        return decode(cryptogram);
    }
}
