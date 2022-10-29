package onboarding;

import java.util.List;
import onboarding.problem6.CrewNicknameService;
import onboarding.problem6.CrewRepository;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        CrewRepository crewRepository = new CrewRepository(forms);
        CrewNicknameService crewNicknameService = new CrewNicknameService(crewRepository);

        return crewNicknameService.calculateDuplicateCrews();
    }
}
