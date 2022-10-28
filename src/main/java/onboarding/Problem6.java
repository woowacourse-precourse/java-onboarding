package onboarding;

import static onboarding.problem6.CrewNicknameChecker.calculateDuplicateCrews;

import java.util.List;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        return calculateDuplicateCrews(forms);
    }
}
