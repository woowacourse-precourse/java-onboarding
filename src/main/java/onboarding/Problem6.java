package onboarding;

import java.util.List;
import onboarding.problem06.entity.Crews;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Crews crews = Crews.from(forms);
        List<String> answer = crews.run();
        return answer;
    }
}
