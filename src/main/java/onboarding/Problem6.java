package onboarding;

import java.util.List;
import onboarding.problem6.JoinFormUtils;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        JoinFormUtils joinFormUtils = new JoinFormUtils();
        joinFormUtils.join(forms);
        return joinFormUtils.findEmailsByDuplicateNickNames();
    }
}
