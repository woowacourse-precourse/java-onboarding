package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static boolean anyOverlap(String target) {
        for (int i = 0; i < target.length() - 1; i++) {
            if (target.charAt(i) == target.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

    public static String removeOverlap(String target) {
        String result = "";

        boolean overlapPosition[] = new boolean[target.length()];

        for (int i = 0; i < target.length() - 1; i++) {
            if (target.charAt(i) == target.charAt(i+1)) {
                overlapPosition[i] = true;
                overlapPosition[i+1] = true;
                break;
            }
        }

        for (int i = 0; i < target.length(); i++) {
            if (!overlapPosition[i]) {
                result += target.charAt(i);
            }
        }

        return result;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = cryptogram;
        while(anyOverlap(answer)) {
            answer = removeOverlap(answer);
        }

        return answer;
    }
}
