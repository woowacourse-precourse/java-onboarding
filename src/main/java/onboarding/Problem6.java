package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            set.addAll(getContainsSet(forms, i));
        }

        answer.addAll(set);
        Collections.sort(answer, String.CASE_INSENSITIVE_ORDER);
        return answer;
    }

    private static Set<String> getContainsSet(List<List<String>> forms, int i) {
        Set<String> containsSet = new HashSet<>();
        List<String> info = forms.get(i);
        String nickname = info.get(1);

        for (int j = 0; j < nickname.length() - 1; j++) {
            String tmp = String.valueOf(nickname.charAt(j)) + (nickname.charAt(j + 1));
            for (int q = 0; q < forms.size(); q++) {
                if (i == q) continue;

                List<String> targetList = forms.get(q);
                String targetNickname = targetList.get(1);
                String targetEmail = targetList.get(0);

                if (targetNickname.contains(tmp)) containsSet.add(targetEmail);
            }
        }

        return containsSet;
    }
}
