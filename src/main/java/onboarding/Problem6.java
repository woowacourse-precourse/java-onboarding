package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    static List<String> answer = new ArrayList<>();
    static Set<String> nicknames = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        for (List<String> crew : forms) {
            if (cannotUser(crew.get(1))) {
                answer.add(crew.get(0));
            }
        }
        List<String> firstCrew = forms.get(0);
        if (cannotUser(firstCrew.get(1))) {
            answer.add(firstCrew.get(0));
        }
        return answer;
    }

    private static boolean cannotUser(String nickname) {
        boolean result = false;
        for (int i = 0; i < nickname.length() - 1; i++) {
            for (int j = i + 2; j < nickname.length(); j++) {
                String subNickname = nickname.substring(i, j);
                if (nicknames.contains(subNickname)) {
                    result = true;
                }
                nicknames.add(nickname);
            }
        }
        return result;
    }
}
