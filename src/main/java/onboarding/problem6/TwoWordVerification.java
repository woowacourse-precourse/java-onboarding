package onboarding.problem6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoWordVerification {

    public Map<String, Integer> CountOfCase(Set<String> cases, List<CrewMember> crewMemberList) {

        Map<String, Integer> resultMap = new HashMap<>();

        for (String word : cases) {

            int count = 0;
            for (CrewMember crewMember : crewMemberList) {
                if (crewMember.getNickname().contains(word)) {
                    count++;
                }
            }

            resultMap.put(word, count);
        }


        return resultMap;
    }

    public List<String> DuplicatedCase(Map<String, Integer> CountCase) {
        return null;
    }


}
