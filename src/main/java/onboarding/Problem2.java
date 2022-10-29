package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        for (int i = 0; i < answer.length() - 1; i++) {
            char c = answer.charAt(i);
            if (c == answer.charAt(i + 1)) {
                answer = removeConsecutiveChars(answer, i);
                i = -1;
            }
        }

        return answer;
    }

    private static String removeConsecutiveChars(String str, int index) {
        String removedStr = str.substring(index, index + 2);
        return str.replace(removedStr, "");
    }
}
