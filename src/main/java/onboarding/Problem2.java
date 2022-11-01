package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        return decode(cryptogram);
    }

    private static String decode(String c) {
        boolean flag = true;

        while (flag) {
            flag = false;
            int count = 0;

            for (int i = 1; i < c.length(); i++) {
                if (c.charAt(i) == c.charAt(i - 1)) {
                    count++;
                } else if (count > 0) {
                    c = c.substring(0, i - count - 1) + c.substring(i);
                    i -= count + 1;
                    count = 0;
                    flag = true;
                }
            }

            if (count > 0) {
                c = c.substring(0, c.length() - count - 1);
            }
        }

        return c;
    }
}
