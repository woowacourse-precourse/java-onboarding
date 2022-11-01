package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        return checkDuplicateWord(cryptogram);
    }

    private static String checkDuplicateWord(String cryptogram) {
        List<Integer> indexList = new ArrayList<>();
        while (true) {
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    indexList.add(i);
                    indexList.add(i + 1);
                }
            }
            if (indexList.size() == 0) {
                break;
            }
            cryptogram = removeDuplicateWord(cryptogram, indexList);
            indexList = new ArrayList<>();
        }
        return cryptogram;
    }
    private static String removeDuplicateWord(String cryptogram, List<Integer> indexList) {
        Set<Integer> set = new HashSet<Integer>(indexList);
        List<Integer> fixedIndexList = new ArrayList<Integer>(set);
        Collections.reverse(fixedIndexList);
        StringBuffer stringBuffer = new StringBuffer(cryptogram);
        for (int index : fixedIndexList) {
            stringBuffer.deleteCharAt(index);
        }
        return stringBuffer.toString();
    }
}
