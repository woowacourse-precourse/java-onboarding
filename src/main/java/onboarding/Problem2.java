package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int cursor = 0;

        while (true) {
            if (cursor + 1 >= cryptogram.length()) {
                break;
            }

            if (cryptogram.charAt(cursor) == cryptogram.charAt(cursor + 1)) {
                cryptogram = cryptogram.substring(0, cursor) + cryptogram.substring(cursor + 2);
                if (cursor > 0) {
                    --cursor;
                }
                continue;
            }
            ++cursor;
        }

        return cryptogram;
    }
}
