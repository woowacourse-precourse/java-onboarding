package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String password = "";

        while (true) {
            if (cryptogram.equals(password)) break;
        }

        return password;
    }

    public static int findlastDuplicateIndex(String cryptogram, int index) {
        char target = cryptogram.charAt(index);
        while (index < cryptogram.length()) {
            if (target != cryptogram.charAt(index)) {
                break;
            }

            index++;
        }

        return index - 1;
    }
}
