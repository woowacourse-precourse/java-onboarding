package onboarding;

import onboarding.problem6.DuplicateChecker;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        DuplicateChecker checker = new DuplicateChecker();
        checker.inputDatas(forms);
        return checker.getUsers();
    }
}
