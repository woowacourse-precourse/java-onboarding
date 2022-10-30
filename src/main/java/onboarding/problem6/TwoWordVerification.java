package onboarding.problem6;

import java.util.*;

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

        ArrayList<String> resultList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : CountCase.entrySet()) {
            if (entry.getValue() >= 2) {
                resultList.add(entry.getKey());
            }
        }

        return resultList;
    }


}
