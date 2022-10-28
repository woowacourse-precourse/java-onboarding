package onboarding;

import java.util.List;
import onboarding.problem6.CrewNicknameChecker;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        CrewNicknameChecker checker = new CrewNicknameChecker(forms);

        return checker.calculateDuplicateCrews();
    }
}
