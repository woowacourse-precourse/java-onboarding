package onboarding;

import onboarding.problem6.service.NicknameService;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return NicknameService.duplicateNicknameEmail(forms);
    }
}
