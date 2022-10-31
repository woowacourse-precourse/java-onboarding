package onboarding;

import java.util.List;
import onboarding.problem6.CrewDuplicateNicknameService;
import onboarding.problem6.CrewRepository;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        CrewRepository crewRepository = new CrewRepository(forms);
        CrewDuplicateNicknameService crewDuplicateNicknameService = new CrewDuplicateNicknameService(crewRepository);

        return crewDuplicateNicknameService.findDuplicateCrews();
    }
}
