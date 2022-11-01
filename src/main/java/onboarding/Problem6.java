package onboarding;

import java.util.*;

public class Problem6 {
    private static List<List<String>> makeSliceByTwo(List<List<String>> forms) {
        List<List<String>> sliceList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            List<String> slices = new ArrayList<>();
            String nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                String slice = nickname.substring(j, j + 2);
                slices.add(slice);
            }
            sliceList.add(slices);
        }

        return sliceList;
    }
    private static Set<String> makeSliceSet(List<List<String>> sliceList) {
        Set<String> tempSet = new HashSet<>();
        Set<String> sliceSet = new HashSet<>();

        for (int i = 0; i < sliceList.size(); i++) {
            for (int j = 0; j < sliceList.get(i).size(); j++) {
                String slice = sliceList.get(i).get(j);

                if (tempSet.contains(slice)) {
                    sliceSet.add(slice);
                    continue;
                }
                tempSet.add(slice);
            }
        }

        return sliceSet;
    }
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
        boolean[] isConsecutive = makeConsecutiveCheckArray(forms);
        List<String> emailList = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            if (isConsecutive[i]) {
                String email = forms.get(i).get(0);
                emailList.add(email);
            }
        }

        return emailList;
    }
}
