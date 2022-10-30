package onboarding.problem6.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NicknameChecker {

    public Set<Crew> findCrewsWithDuplicatedNickname(List<Crew> crews) {
        Set<Crew> crewsWithDuplicatedNickname = new HashSet<>();

        // 처음으로 등록된 부분문자열과 해당 닉네임의 주인을 저장할 MAP
        HashMap<String, Crew> nicknameOwnerMap = new HashMap<>();

        for (Crew crew : crews) {
            Nickname nickname = crew.getNickname();
            Set<String> subStrings = nickname.allSubStringWithSize(2);

            for (String subString : subStrings) {
                if (!nicknameOwnerMap.containsKey(subString)) {
                    // 닉네임이 중복되지 않은 경우
                    nicknameOwnerMap.put(subString, crew);
                    continue;
                }

                // 중복된 경우
                crewsWithDuplicatedNickname.add(nicknameOwnerMap.get(subString));
                crewsWithDuplicatedNickname.add(crew);
            }
        }
        return crewsWithDuplicatedNickname;
    }
}
