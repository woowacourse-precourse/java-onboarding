package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                cryptogram = cryptogram.substring(0, i)
                        + cryptogram.substring(i + 2);

                cryptogram = checkDuplicatedStringAgain(cryptogram, i);

                return solution(cryptogram);
            }
        }
        return cryptogram;
    }

    public static String checkDuplicatedStringAgain(String cryptogram,
                                                    int duplicatePositions) {
        for (int i = duplicatePositions; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                cryptogram = cryptogram.substring(0, i)
                        + cryptogram.substring(i + 2);
            }
        }
        return cryptogram;
    }
}