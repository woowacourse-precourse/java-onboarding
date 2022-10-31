package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            for (int j = 0; j < nickname.length() - 1; j++) {
                String key = nickname.substring(j, j + 2);
                for (int k = i + 1; k < forms.size(); k++) {
                    if (forms.get(k).get(1).contains(key)) {
                        result.add(email);
                        result.add(forms.get(k).get(0));
                    }
                }
            }
        }

        answer.addAll(result);

        return answer;
    }
}
