package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static String getEmail(List<String> form) {
        return form.get(0);
    }

    private static String getNickName(List<String> form) {
        return form.get(1);
    }
}
