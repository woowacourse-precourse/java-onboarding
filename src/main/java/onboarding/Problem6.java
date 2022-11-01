package onboarding;

import java.util.List;
import onboarding.problem06.entity.Crews;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Crews.from(forms);
        List<String> answer = List.of("answer");
        return answer;
    }
}
