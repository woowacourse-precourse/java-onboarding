package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) throws Exception {
        validate(forms);
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void validate(List<List<String>> forms) throws Exception {
        if (forms.size() < 1 || forms.size() > 10_000) {
            throw new Exception("크루들의 숫자는 1이상 10000이하만 가능합니다");
        }

    }
}
