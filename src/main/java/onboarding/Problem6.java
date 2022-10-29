package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            List<String> info = forms.get(i);
            String nickname = info.get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                String tmp = String.valueOf(nickname.charAt(j)) + (nickname.charAt(j + 1));
            }
        }

        answer.addAll(set);
        Collections.sort(answer, String.CASE_INSENSITIVE_ORDER);
        return answer;
    }
}
