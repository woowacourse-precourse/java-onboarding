package onboarding;

import java.util.List;
import onboarding.problem6.CrewInfo;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        CrewInfo checker = new CrewInfo(forms);

        return checker.calculateDuplicateCrews();
    }
}
