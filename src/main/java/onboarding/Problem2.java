package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        List<String> charList = new ArrayList<>(List.of(cryptogram.split("")));

        while (true) {
            List<Integer> indexesToRemove = findIndexesToRemove(charList);
            if (indexesToRemove.isEmpty()) {
                break;
            }
            removeIndexes(charList, indexesToRemove);
        }
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
        Collections.sort(indexesToRemove, Comparator.reverseOrder());
        return indexesToRemove;
    }

    private static List<String> removeIndexes(List<String> charList, List<Integer> indexesToRemove) {
        for (int index : indexesToRemove) {
            charList.remove(index);
        }
        return charList;
    }
}