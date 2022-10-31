package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static List<String> getSubstrFromNickname(String nickname) {
        List<String> substrings = new ArrayList<>(List.of());
        for (int idx = 0; idx < nickname.length() - 1; idx++) {
            substrings.add(nickname.substring(idx, idx + 2));
        }
        return substrings;
    }
}
