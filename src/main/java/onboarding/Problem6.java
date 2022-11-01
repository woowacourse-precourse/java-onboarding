package onboarding;

import onboarding.problem6.repository.CrewRepository;
import onboarding.problem6.repository.CrewRepositoryImpl;
import onboarding.problem6.service.CrewService;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        CrewRepository crewRepository = new CrewRepositoryImpl();
        CrewService crewService = new CrewService(crewRepository);

        crewService.saveAllCrews(forms);
        return crewService.findAllEmailByCrewsHavingInvalidName();
    }
}
