package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = search(forms);

        answer = answer.stream()
                .distinct().sorted()
                .collect(Collectors.toList());

        return answer;
    }
}
