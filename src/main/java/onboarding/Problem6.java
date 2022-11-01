package onboarding;

import java.util.*;

public class Problem6 {
    private static boolean[] makeConsecutiveCheckArray(List<List<String>> forms) {
        boolean[] isConsecutive = new boolean[forms.size()];
        List<List<String>> sliceList = makeSliceByTwo(forms);
        Set<String> sliceSet = makeSliceSet(sliceList);

        for (int i = 0; i < sliceList.size(); i++) {
            List<String> slices = sliceList.get(i);
            for (int j = 0; j < slices.size(); j++) {
                String slice = slices.get(j);
                if (sliceSet.contains(slice)) {
                    isConsecutive[i] = true;
                    break;
                }
            }
        }

        return isConsecutive;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        boolean[] isConsecutive = makeConsecutiveCheckArray(forms);

        return result;
    }
}
