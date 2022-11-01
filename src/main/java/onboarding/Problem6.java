package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = checkOverlapNickName(forms);

        return answer;
    }

    private static List<String> checkOverlapNickName(List<List<String>> forms) {

        Set<String> uniqueNames = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {

            String originName = forms.get(i).get(1);

            for (int j = 0; j < originName.length()-1; j++) {

                String partName = originName.substring(j,j+2);

                if(checkOverlap(partName, i, forms))
                    uniqueNames.add(forms.get(i).get(0));
            }
        }

        List<String> overlapNickNames = new ArrayList<>(uniqueNames);
        Collections.sort(overlapNickNames);
        return overlapNickNames;
    }

    private static boolean checkOverlap(String str, int currentIndex, List<List<String>> forms) {

        for (int i = 0 ; i < forms.size();++i) {

            if(i == currentIndex)
                continue;

            if(forms.get(i).get(1).contains(str))
                return true;
        }

        return false;
    }
}