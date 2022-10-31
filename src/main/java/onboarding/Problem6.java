package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashSet<String> tmp_answer = new HashSet<>();
        int n = forms.size();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String nickname = forms.get(i).get(1);
            if (nickname.length() == 1)
                continue;
            for (int k = 0; k < nickname.length() - 1; k++) {
                String subName = nickname.substring(k, k + 2);
                for (int j = i + 1; j < n; j++)
                    if (i != j && forms.get(j).get(1).matches("(.*)" + subName + "(.*)")) {
                        tmp_answer.add(forms.get(i).get(0));
                        tmp_answer.add(forms.get(j).get(0));
                    }
            }
        }
        for (String x : tmp_answer)
            answer.add(x);
        Collections.sort(answer);
        return answer;
    }
}
