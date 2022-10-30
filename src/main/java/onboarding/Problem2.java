package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decode(cryptogram);
    }

    private static String decode(String c) {
        int count = 0;

        for (int i = 1; i < c.length(); i++) {
            if (i >= 0 && c.charAt(i) == c.charAt(i - 1)) {
                count++;
            } else if (count > 0) {
                c = c.substring(0, i - count - 1) + c.substring(i);
                i -= count + 2;
                count = 0;
            }
        }

        if (count > 0) {
            c = c.substring(0, c.length() - count - 1);
        }

        return c;
    }
}
