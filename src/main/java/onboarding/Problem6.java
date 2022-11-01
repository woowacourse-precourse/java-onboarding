package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(List.of("answer"));
        List<String> temp = new ArrayList<>(Collections.emptyList());

        String name;
        String s;
        String compare;

        for (List<String> form : forms) {
            temp.add(form.get(1));
        }

        int[] cnt = new int[forms.size()];
        for (int i = 0; i < forms.size(); i++)
            cnt[i] = 0;

        for (List<String> i : forms) {
            name = i.get(1);
            for (int k = 0; k < name.length() - 1; k++) {
                s = name.substring(k, k + 2);
                int c = 0;
                for (List<String> j : forms) {
                    if (j.get(1).contains(s) && !j.equals(i)) {
                        cnt[c]++;
                    }
                    c++;
                }
            }
        }

        answer.clear();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0)
                answer.add(forms.get(i).get(0));
        }

        Collections.sort(answer);
        return answer;
    }
}
