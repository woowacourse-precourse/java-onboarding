package onboarding;

import onboarding.problem6.CrewService;
import onboarding.problem6.NicknameCheckService;
import onboarding.problem6.crew.CrewFactory;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        validateSize(forms.size());

        CrewService crewService = new CrewService(new NicknameCheckService(), new CrewFactory());
        return crewService.checkCrew(forms);
    }

    private static void validateSize(int size) {
        final int MIN_VALUE = 1;
        final int MAX_VALUE = 10_000;

        if (size < MIN_VALUE || MAX_VALUE < size) {
            throw new IllegalArgumentException("크루원은 1명 이상 10,000명 이하로 입력 해주세요.");
        }
    }
}
