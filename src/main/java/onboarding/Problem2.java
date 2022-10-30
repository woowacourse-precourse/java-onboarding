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
        HashSet<Integer> duplicationSet = getDupiicationSet(inputArrayList);
        ArrayList<String> outputArrayList = removeDuplicationBySet(inputArrayList, duplicationSet);
        String answer = joinStringWithoutNull(outputArrayList);
        return answer;
    }
}
