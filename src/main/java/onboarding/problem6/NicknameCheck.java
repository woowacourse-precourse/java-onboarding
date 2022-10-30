package onboarding.problem6;

import java.util.*;

public class NicknameCheck {

    public List<String> DuplicateCrewMember(List<CrewMember> crewMemberList) {

        List<String> result = new ArrayList<>();

        NicknameAllCases nicknameAllCases = new NicknameAllCases();
        Set<String> setList = nicknameAllCases.createCase(crewMemberList);

        TwoWordVerification twoWordVerification = new TwoWordVerification();
        Map<String, Integer> countOfCase = twoWordVerification.CountOfCase(setList, crewMemberList);

        List<String> duplicatedCase = twoWordVerification.DuplicatedCase(countOfCase);

        for (String cases : duplicatedCase) {

            for (CrewMember crew : crewMemberList) {
                if (crew.getNickname().contains(cases)) {
                    result.add(crew.getEmail());
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}

