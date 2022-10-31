package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        List<String> charList = List.of(cryptogram.split(""));
        List<Integer> indexesToRemove = findIndexesToRemove(charList);
        return answer;
    }

    private static List<Integer> findIndexesToRemove(List<String> charList) {
        List<Integer> indexesToRemove = new ArrayList<>();
        for (int i = 0; i < charList.size(); i++) {
            if (i != 0 && charList.get(i).equals(charList.get(i-1))) {
                indexesToRemove.add(i);
                indexesToRemove.add(i-1);
            }
        }
        if (indexesToRemove.isEmpty()) {
            return List.of(-1);
        }
        return indexesToRemove;
    }
}