package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        Set<String> answerSet = new LinkedHashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            Set<String> tempName = new LinkedHashSet<>();
            for (int j = 0; j < name.length() - 1; j++) {
                tempName.add(name.substring(j, j + 2));
            }
            for (int j = i + 1; j < forms.size(); j++) {
                for (String str : tempName) {
                    if (forms.get(j).get(1).contains(str)) {
                        answerSet.add(forms.get(i).get(0));
                        answerSet.add(forms.get(j).get(0));
                    }
                }
            }
        }
        List<String> answer = new ArrayList<>(answerSet);
        Collections.sort(answer);
        return answer;
    }

}
