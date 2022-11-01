package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import onboarding.problem6.DuplicatePool;
import onboarding.problem6.crew.Crew;
import onboarding.problem6.crew.CrewService;
import onboarding.problem6.dto.CrewInfoListDto;

public class Problem6 {
    private static final int EMAIL_INDEX = 0;
    private static final int NICKNAME_INDEX = 1;

    private static final CrewService crewService = new CrewService();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        CrewInfoListDto crewInfoListDto = new CrewInfoListDto(forms);
        crewService.saveCrewsByCrewInfos(crewInfoListDto);

        List<Crew> allCrews = crewService.getAllCrews();
        for (Crew crew : allCrews) {
            String nickname = crew.getNickname();
            DuplicatePool.fillByWord(nickname, 2); //FIXME 매직넘버
        }

        List<Crew> duplicateCrews = DuplicatePool.findDuplicateNicknameCrews(allCrews);

        answer = duplicateCrews.stream()
            .map(Crew::getEmail)
            .distinct()
            .sorted()
            .collect(Collectors.toList());

        return answer;
    }
}

class TwoSizeWord {
    private String word;

    public TwoSizeWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}