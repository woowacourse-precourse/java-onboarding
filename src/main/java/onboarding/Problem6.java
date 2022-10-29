package onboarding;

import java.util.List;
import onboarding.problem6.CrewRepository;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        CrewRepository checker = new CrewRepository(forms);

        return checker.calculateDuplicateCrews();
    }
}
