package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static final int LETTERS = 2;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static List<String> getSubNicknames(String nickname) {
        List<String> subNicknames = new ArrayList<>();
        for (int i = 0; i <= nickname.length() - LETTERS; i++) {
            subNicknames.add(nickname.substring(i, i + LETTERS));
        }

        return subNicknames;
    }
}
