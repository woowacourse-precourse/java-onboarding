package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    static List<String> answer = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> crew : forms) {
            if (cannotUser(crew.get(1))) {

            }
        }
        return answer;
    }

    private static boolean cannotUser(String nickname) {
        boolean result = false;
        for (int i = 0; i < nickname.length() - 1; i++) {
            for (int j = i + 2; j < nickname.length(); j++) {
                String subNickname = nickname.substring(i, j);

            }
        }
        return result;
    }
}
