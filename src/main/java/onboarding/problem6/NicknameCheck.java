package onboarding.problem6;

import java.util.*;

public class NicknameCheck {

    public List<String> DuplicateCrew(List<Crew> crewList) {

        List<String> result = new ArrayList<>();

        NicknameAllCases nicknameAllCases = new NicknameAllCases();
        Set<String> setList = nicknameAllCases.createCase(crewList);

        TwoWordVerification twoWordVerification = new TwoWordVerification();
        Map<String, Integer> countOfCase = twoWordVerification.CountOfCase(setList, crewList);

        List<String> duplicatedCase = twoWordVerification.DuplicatedCase(countOfCase);

        for (String cases : duplicatedCase) {

            for (Crew crew : crewList) {
                if (crew.getNickname().contains(cases)) {
                    result.add(crew.getEmail());
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}

