package onboarding;

import java.util.ArrayList;
import java.util.List;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static List<Integer> overlapNum(String inputString) {
        List<Integer> overlapList = new ArrayList<Integer>();

        for (int i = 0; i < inputString.length() - 1; i++) {
            if (inputString.charAt(i) == inputString.charAt(i + 1)) {
                overlapList.add(i);
            }
        }

        return overlapList;
    }
}
