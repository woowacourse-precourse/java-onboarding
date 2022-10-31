package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static List<List<Integer>> findDeduplication(String cryptogram) {
        int start = 0;
        int end = 0;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> index;

        while ((start < cryptogram.length()) && (end < cryptogram.length())) {
            while ((end < cryptogram.length()) && (cryptogram.charAt(start) == cryptogram.charAt(end))) {
                end += 1;
            }
            if (end - start >= 2) {
                index = new ArrayList<>();
                index.add(start);
                index.add(end);
                list.add(index);
            }
            start = end;
            end += 1;
        }
        return list;
    }

    public static String solution(String cryptogram) {
        String answer = cryptogram;
        List<List<Integer>> remove;
        int start = 0;
        int end = 0;

        while (true) {
            remove = findDeduplication(answer);
            if (remove.size() == 0) {
                break;
            }
            for (int i = remove.size() - 1; i >= 0; i--) {
                start = remove.get(i).get(0);
                end = remove.get(i).get(1);
                answer = answer.substring(0, start) + answer.substring(end);
            }
        }

        return answer;
    }
}
