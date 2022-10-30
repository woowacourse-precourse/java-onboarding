package onboarding;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";


        while (hasDuplicated(cryptogram)) {
            //중복 제거 로직
        }


        return answer;
    }

    private static boolean hasDuplicated(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}
