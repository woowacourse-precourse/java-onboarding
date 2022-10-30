package onboarding;

import onboarding.problem6.CrewNicknameManager;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return new CrewNicknameManager(forms).findEmailOfCrewsPartiallyDuplicateNickname();
    }
}
