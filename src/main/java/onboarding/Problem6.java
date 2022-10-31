package onboarding;

import onboarding.domain.problem6.Info;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Info info = new Info(forms);
        return info.overlapEmail();
    }
}
