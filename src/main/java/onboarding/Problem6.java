package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static List<String> separateNickname(String nickname) {
        List<String> parts = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            parts.add(nickname.substring(i, i + 2));
        }
        return parts;
    }
}
