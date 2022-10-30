package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int point1 = 0;
        int point2 = 1;

        while (point2 < cryptogram.length()) {
            char first = cryptogram.charAt(point1);
            char second = cryptogram.charAt(point2);

            if (isSameWord(first, second)) {
                cryptogram = getNewCryptogram(cryptogram, point1, point2);
                point1 = 0;
                point2 = 1;
                continue;
            }
            point1++;
            point2++;
        }
        return cryptogram;
    }

    private static String getNewCryptogram(String cryptogram, int point1, int point2) {
        return cryptogram.substring(0, point1) + cryptogram.substring(point2 + 1);
    }

    private static boolean isSameWord(char first, char second) {
        if (first == second) {
            return true;
        }
        return false;
    }
}
