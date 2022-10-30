package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        String prev = removeDuplication(cryptogram);
        String next;
        while (true) {
            next = removeDuplication(prev);
            if (next.equals(prev)) {
                answer = next;
                break;
            }
            prev = next;
        }
        return answer;
    }

    static String removeDuplication(String cryptogram) {
        ArrayList<String> inputArrayList = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        HashSet<Integer> duplicationIndexSet = getDuplicationIndexSet(inputArrayList);
        ArrayList<String> outputArrayList = removeDuplicationBySet(inputArrayList, duplicationIndexSet);
        String answer = joinStringWithoutNull(outputArrayList);
        return answer;
    }

    static HashSet<Integer> getDuplicationIndexSet(ArrayList<String> inputArrayList) {
        HashSet<Integer> duplicationSet = new HashSet<>();
        for (int i = 0; i < inputArrayList.size() - 1; i++) {
            String pre = inputArrayList.get(i);
            String next = inputArrayList.get(i + 1);
            if (pre.equals(next)) {
                duplicationSet.add(i);
                duplicationSet.add(i + 1);
            }
        }
        return duplicationSet;
    }
}
