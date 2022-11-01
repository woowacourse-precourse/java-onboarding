package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return checkEnd(cryptogram);
    }

    private static String getDecryptedWord(String cryptogram) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (i != 0 && cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
                continue;
            }
            else if (i != cryptogram.length() - 1 && cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                continue;
            }

            result.append(cryptogram.charAt(i));
        }

        return result.toString();
    }

    private static String checkEnd(String cryptogram) {
        while (!cryptogram.equals(getDecryptedWord(cryptogram))) {
            cryptogram = getDecryptedWord(cryptogram);
        }
        return cryptogram;
    }
}
