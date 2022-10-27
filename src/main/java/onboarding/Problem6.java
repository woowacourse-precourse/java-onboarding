package onboarding;

import onboarding.problem6.CrewService;
import onboarding.problem6.NicknameCheckService;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        CrewService crewService = new CrewService(new NicknameCheckService());
        return crewService.checkCrew(forms);
    }
}
