package onboarding;

public class Problem2 {

    private static boolean isEncrypted(String crypto) {
        char prev = crypto.charAt(0);

        for (int i = 1; i < crypto.length(); i++) {
            if (prev == crypto.charAt(i)) {
                return (false);
            }
            else {
                prev = crypto.charAt(i);
            }
        }
        return (true);
    }

    private static String encrypt(String crypto) {
        String result = "";

        int prev = 0;
        for (int i = 1; i < crypto.length(); i++) {
            if (crypto.charAt(prev) != crypto.charAt(i)) {
                if (prev + 1 == i) {
                    result += crypto.charAt(prev);
                }
                prev = i;
                if (i + 1 == crypto.length()) {
                    result += crypto.charAt(i);
                }
            }
        }
        return result;
    }

    public static String solution(String cryptogram) {
        while (cryptogram.length() > 0 && !isEncrypted(cryptogram)) {
            cryptogram = encrypt(cryptogram);
        }
        return cryptogram;
    }
}
