package onboarding.problem6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NicknameAllCases {

    public Set<String> cases(String nickname) {
        Set<String> resultSet = new HashSet<>();

        for (int nicknameIndex = 0; nicknameIndex < nickname.length() - 1; nicknameIndex++) {

            String substring = nickname.substring(nicknameIndex, nicknameIndex + 2);
            resultSet.add(substring);
        }

        return resultSet;
    }

    public Set<String> createCase(List<Crew> crewList) {
        Set<String> set = new HashSet<>();

        for (Crew crew : crewList) {
            set.addAll(cases(crew.getNickname()));
        }

        return set;
    }
}
