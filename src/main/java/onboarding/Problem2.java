package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem2 {

    public static String solution(String cryptogram) {
        List<String> splitCryptogram = new ArrayList<>(List.of(cryptogram.split("")));
        int idx = 1;
        while (splitCryptogram.size() != 0) {
            if (isNoDuplicate(splitCryptogram, idx)) break;
            if (isDuplicateCheck(splitCryptogram, idx)) {
                removeDuplicate(splitCryptogram, idx);
                idx = 1;
                continue;
            }
            idx++;
        }
        return String.join("", splitCryptogram);
    }
    public static boolean isNoDuplicate(List<String> str, int idx) {
        return str.size() == idx;
    }

    public static boolean isDuplicateCheck(List<String> str, int idx) {
        return str.get(idx-1).equals(str.get(idx));
    }

    public static void removeDuplicate(List<String> strList, int idx) {
        strList.remove(idx);
        strList.remove(idx-1);
    }
}
