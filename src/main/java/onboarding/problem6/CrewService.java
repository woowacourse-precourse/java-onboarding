package onboarding.problem6;

import onboarding.problem6.crew.Crew;
import onboarding.problem6.crew.CrewFactory;

import java.util.List;

public class CrewService {

    private final NicknameCheckService nicknameCheckService;
    private final CrewFactory crewFactory;

    public CrewService(NicknameCheckService nicknameCheckService, CrewFactory crewFactory) {
        this.nicknameCheckService = nicknameCheckService;
        this.crewFactory = crewFactory;
    }

    public List<String> checkCrew(List<List<String>> forms) {
        List<Crew> crewList = crewFactory.getCrewList(forms);
        return nicknameCheckService.getDuplicateCrewEmail(crewList);
    }
}
