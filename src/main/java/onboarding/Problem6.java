package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        boolean[] overlapString = new boolean[forms.size()];
        for (int i = 0; i < forms.size() - 1; i++) {
            Set<String> set = new HashSet<>();
            StringBuilder sb1 = new StringBuilder(forms.get(i).get(1));
            if (sb1.length() == 1) {
                continue;
            }
            for (int j = 0; j < sb1.length() - 1; j++) {
                set.add(sb1.substring(j, j + 2));
            }
            for (int j = i + 1; j < forms.size(); j++) {
                StringBuilder sb2 = new StringBuilder(forms.get(j).get(1));
                if (sb2.length() == 1) {
                    continue;
                }
                for (int k = 0; k < sb2.length() - 1; k++) {
                    if (set.contains(sb2.substring(k, k + 2))) {
                        overlapString[i] = true;
                        overlapString[j] = true;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < overlapString.length; i++) {
            if (overlapString[i]) {
                answer.add(forms.get(i).get(0));
            }
        }
        Collections.sort(answer);


        return answer;

    }
}
