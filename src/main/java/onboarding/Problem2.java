package onboarding;

import java.util.ArrayList;
import java.util.List;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while (overlapNum(answer).size() != 0) {
            char[] chars = answer.toCharArray();
            for (int j = 0; j < overlapNum(answer).size(); j++) {
                chars[overlapNum(answer).get(j)] = ' ';
                chars[overlapNum(answer).get(j) + 1] = ' ';
            }
            answer = String.valueOf(chars).replaceAll(" ", "");
        }

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
