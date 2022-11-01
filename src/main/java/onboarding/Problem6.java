package onboarding;

import static onboarding.problem6.Problem6Constant.*;

import java.util.ArrayList;
import java.util.List;

import onboarding.problem6.crew.Crew;
import onboarding.problem6.crew.CrewService;
import onboarding.problem6.dto.CrewInfoListDto;
import onboarding.problem6.util.duplication.DuplicatePool;

public class Problem6 {
    private static final CrewService crewService = new CrewService();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        CrewInfoListDto crewInfoListDto = new CrewInfoListDto(forms);
        crewService.saveCrewsByCrewInfos(crewInfoListDto);

        List<Crew> allCrews = crewService.getAllCrews();
        for (Crew crew : allCrews) {
            String nickname = crew.getNickname();
            DuplicatePool.fillByWord(nickname, NICKNAME_DUPLICATE_WORD_LENGTH);
        }

        List<Crew> duplicateCrews = new ArrayList<>();
        for (Crew crew : allCrews) {
            if (DuplicatePool.isDuplicateNickname(crew.getNickname())) {
                duplicateCrews.add(crew);
            }
        }

        answer = crewService.toResultForm(duplicateCrews);

        return answer;
    }

}