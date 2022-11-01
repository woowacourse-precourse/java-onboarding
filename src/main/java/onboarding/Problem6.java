package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);

            for (int j = 0; j < nickname.length() - 1; j++) {
                String tmp = nickname.substring(j, j + 2);

                for (int k = i + 1; k < forms.size(); k++) {
                    String check = forms.get(k).get(1);

                    if (check.contains(tmp)) {
                        set.add(forms.get(i).get(0));
                        set.add(forms.get(k).get(0));
                    }
                }
            }
        }

        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);

        return answer;
    }
}
