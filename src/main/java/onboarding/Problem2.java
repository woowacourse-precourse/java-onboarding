package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static boolean compareAdjacent(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}

