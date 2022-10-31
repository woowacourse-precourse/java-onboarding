package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (canMoreDelete(cryptogram)) {
            cryptogram = getNewCryptogram(cryptogram);
        }

        return cryptogram;
    }

    private static boolean canMoreDelete(String cryptogram) {
        if (cryptogram.length() == 0 || cryptogram.length() == 1) return false;

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) return true;
        }

        return false;
    }

    private static String getNewCryptogram(String cryptogram) {
        boolean[] isDuplicate = new boolean[cryptogram.length()];

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                isDuplicate[i] = true;
                isDuplicate[i + 1] = true;
            }
        }

        String ret = "";

        for (int i = 0; i < cryptogram.length(); i++) {
            if (isDuplicate[i]) continue;
            ret += cryptogram.charAt(i);
        }

        return ret;
    }
}
