package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder stringBuilder = new StringBuilder(cryptogram);
        while(true) {
            List<Integer> nearByDuplication = getNearByDuplication(stringBuilder);
            if (nearByDuplication.isEmpty()) {
                break;
            }
            removeNearByDuplication(stringBuilder, nearByDuplication);
        }
        return stringBuilder.toString();
    }

    private static void removeNearByDuplication(StringBuilder stringBuilder, List<Integer> nearByDuplication) {
        nearByDuplication.sort(Comparator.reverseOrder());
        nearByDuplication.forEach(stringBuilder::deleteCharAt);
    }

    private static List<Integer> getNearByDuplication(StringBuilder stringBuilder) {
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < stringBuilder.length() - 1; ++i) {
            if (stringBuilder.charAt(i) == stringBuilder.charAt(i + 1)) {
                ret.add(i);
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
