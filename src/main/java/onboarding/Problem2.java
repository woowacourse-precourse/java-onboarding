package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (cryptogram.length() > 0 && !isOverlapped(cryptogram)) {
            cryptogram = transferString(cryptogram);
        }
        return cryptogram;
    }

    private static boolean isOverlapped(String cryptogram) {
        char previous = cryptogram.charAt(0);

        for (int i = 1; i < cryptogram.length(); i++) {
            if (previous == cryptogram.charAt(i)) {
                return false;
            } else {
                previous = cryptogram.charAt(i);
            }
        }
        return true;
    }

    private static String transferString(String cryptogram) {
        StringBuilder result = new StringBuilder();
        int prevIndex = 0;

        for (int i = 0; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(prevIndex) != cryptogram.charAt(i)) {
                if (prevIndex + 1 == i) {
                    result.append(cryptogram.charAt(prevIndex));
                }
                prevIndex = i;
                // 가장 마지막 문자를 넣기 위해
                if (i + 1 == cryptogram.length()) {
                    result.append(cryptogram.charAt(prevIndex));
                }
            }
        }
        return result.toString();
    }
}
