package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int s = -1;
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
                if (s == -1) {
                    s = i - 1;
                }
            }
            else if (s != -1) {
                cryptogram = cryptogram.substring(0, s) + cryptogram.substring(i);
                i = s - 1;
                s = -1;
            }
        }
        if (s != -1) {
            cryptogram = cryptogram.substring(0, s);
        }
        return cryptogram;
    }
}
