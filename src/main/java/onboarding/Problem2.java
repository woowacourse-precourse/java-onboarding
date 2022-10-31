package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static List<Integer> findConsecutiveChar(String cryptogram) {
        List<Integer> charsToRemove = new ArrayList<>();

        for (int index = 0; index < cryptogram.length(); index++) {
            if (cryptogram.charAt(index) == cryptogram.charAt(index + 1)) {     // 다음 글자와 같을 경우
                charsToRemove.add(index);
                charsToRemove.add(index);
            }
        }
        return charsToRemove;
    }

    private static String removeConsecutiveChar (String cryptogram, List < Integer > charsToRemove){

    }

    private static String decode (String cryptogram){

    }

}
