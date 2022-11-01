package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> splitString(String nickname) {
        List<String> fragment = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++)
            fragment.add(nickname.substring(i, i + 2));
        return fragment;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
