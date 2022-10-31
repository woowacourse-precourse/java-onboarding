package onboarding;

import java.util.List;

public class Problem2 {
    public static List<Integer> duplicatedIndexList;
    public static StringBuilder sb;

    public static String solution(String cryptogram) {
        return cryptogram;
    }

    public static void addDuplicatedIndex(String cryptogram) {
//       duplicatedIndexList.clear();
        char first = ' ', second = ' ';
        for (int index = 0; index < cryptogram.length() - 1; index++) {
            first = cryptogram.charAt(index);
            second = cryptogram.charAt(index + 1);
            if (first == second) {
                duplicatedIndexList.add(index);
                duplicatedIndexList.add(index + 1);
            }
        }
    }
}
