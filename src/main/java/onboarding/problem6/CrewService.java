package onboarding.problem6;

import java.util.*;

import static onboarding.problem6.FormValidator.*;

public class CrewService {

    private final NicknameCheckService nicknameCheckService;

    public CrewService(NicknameCheckService nicknameCheckService) {
        this.nicknameCheckService = nicknameCheckService;
    }

    public List<String> checkCrew(List<List<String>> forms) {
        validateSize(forms.size());  // 크루 1명 이상 10,000명 이하

        List<Crew> crewList = getCrewList(forms);
        validateCrewInfo(crewList);  // 크루 정보 검증

        return nicknameCheckService.getDuplicateCrewEmail(crewList);
    }

    private List<Crew> getCrewList(List<List<String>> forms) {
        List<Crew> crewList = new ArrayList<>();

        for (List<String> form : forms) {  // mail, nickname
            String email = form.get(0);
            String nickname = form.get(1);

            crewList.add(new Crew(email, nickname));
        }

        return crewList;
    }

}
