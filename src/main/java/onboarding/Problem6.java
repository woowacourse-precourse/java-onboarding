package onboarding;

import onboarding.problem6.CrewService;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        CrewService crewService = new CrewService();
        return crewService.getOverlapCrewEmail(forms);
    }
}
