package onboarding;

import java.util.*;

public class Problem6 {
    public static boolean[] overlapedString;
    public static List<String> solution(List<List<String>> forms) {
        overlapedString = new boolean[forms.size()];

        for (int i = 0; i < forms.size() - 1; i++) {
            String str1 = forms.get(i).get(1);
            if (str1.length() == 1) {
                continue;
            }

            searchOverlapedString(forms, i, str1);
        }

        return getStrings(forms);

    }

    private static List<String> getStrings(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < overlapedString.length; i++) {
            if (overlapedString[i]) {
                answer.add(forms.get(i).get(0));
            }
        }
        Collections.sort(answer);

        return answer;
    }

    private static void searchOverlapedString(List<List<String>> forms, int i, String str1) {
        Set<String> set = new HashSet<>();
        for (int j = 0; j < str1.length() - 1; j++) {
            set.add(str1.substring(j, j + 2));
        }
        for (int j = i + 1; j < forms.size(); j++) {
            String str2 = forms.get(j).get(1);
            if (str2.length() == 1) {
                continue;
            }
            for (int k = 0; k < str2.length() - 1; k++) {
                if (set.contains(str2.substring(k, k + 2))) {
                    overlapedString[i] = true;
                    overlapedString[j] = true;
                    break;
                }
            }
        }
    }
}
