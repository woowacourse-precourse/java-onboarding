package onboarding.problem6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NicknameAllCases {

    public Set<String> cases(String nicknames) {
        return null;
    }

    public Set<String> createCase(List<CrewMember> crewMemberList) {
        Set<String> set = new HashSet<>();

        for (CrewMember member : crewMemberList) {
            set.addAll(cases(member.getNickname()));
        }

        return null;
    }
}
