package onboarding;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeDuplicateStr(cryptogram);
    }

    private static String removeDuplicateStr(String cryptogram) {
        Set<Integer> removeSet = new LinkedHashSet<>();
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
                removeSet.add(i - 1);
                removeSet.add(i);
            }
        }

        if (removeSet.size() != 0) {
            cryptogram = removeDuplicateIdx(cryptogram, removeSet);
            return removeDuplicateStr(cryptogram);
        }
        return cryptogram;
    }

    private static String removeDuplicateIdx(String cryptogram, Set<Integer> removeSet) {
        List<Integer> removeList = removeSet.stream().sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        while (!removeList.isEmpty()) {
            Integer idx = removeList.remove(0);
            cryptogram = cryptogram.substring(0, idx) + cryptogram.substring(idx + 1);
        }
        return cryptogram;
    }
}
