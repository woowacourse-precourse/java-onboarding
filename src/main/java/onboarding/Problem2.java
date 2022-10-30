package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    private static List<Integer> getDuplicateIndexes (String cryptogram) {
        List<Integer> indexes = new ArrayList<>();

        for (int i=0; i<cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                indexes.add(i);
            }
        }

        return indexes;
    }
    public static String solution(String cryptogram) {
        List<Integer> duplicateIndexes = getDuplicateIndexes(cryptogram);

        String answer = "answer";
        return answer;
    }
}
