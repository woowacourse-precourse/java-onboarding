package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int k = 0;
        int length = cryptogram.length() - 1;

        for (int i = 0; i < length; i++) {
            k = i + 1;
            if (cryptogram.charAt(i) == cryptogram.charAt(k)) {
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(k + 1);
                break;
            }
        }

        if (k != length) {
            return solution(cryptogram);
        }

        return cryptogram;
    }
}
