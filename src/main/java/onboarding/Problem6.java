package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        Set<Integer> answer_idx = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                String current = nickname.substring(j, j + 2);
                for (int k = 0; k < forms.size(); k++) {
                    if (k != i && forms.get(k).get(1).contains(current)) {
                        answer_idx.add(k);
                    }
                }
            }
        }

        Iterator<Integer> iter = answer_idx.iterator();
        while (iter.hasNext()) {
            answer.add(forms.get(iter.next()).get(0));
        }

        Collections.sort(answer);

        return answer;
    }
}
