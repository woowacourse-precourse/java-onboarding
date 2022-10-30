package onboarding.problem6;

import java.util.HashMap;
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

    public Set<String> createCase(List<CrewMember> crewMemberList) {
        Set<String> set = new HashSet<>();

        for (CrewMember member : crewMemberList) {
            set.addAll(cases(member.getNickname()));
        }

        return set;
    }
}
