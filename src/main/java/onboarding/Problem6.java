package onboarding;

import java.util.*;

public class Problem6 {
    static List<String> answer = new ArrayList<>();
    static Set<String> nicknames = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> crew : forms) {
            addAnswer(crew);
        }
        addAnswer(forms.get(0));
        answer.sort(Comparator.comparing(o -> o.substring(0, o.indexOf("@"))));
        return answer;
    }

    private static void addAnswer(List<String> crew) {
        if (cannotUser(crew.get(1))) {
            answer.add(crew.get(0));
        }
    }

    private static boolean cannotUser(String nickname) {
        boolean result = false;
        for (int i = 0; i < nickname.length() - 1; i++) {
            for (int j = i + 2; j <= nickname.length(); j++) {
                String subNickname = nickname.substring(i, j);
                if (nicknames.contains(subNickname)) {
                    result = true;
                }
                nicknames.add(subNickname);
            }
        }
        return result;
    }
}
