package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicatedCrewsFinder {

    private Map<String, Set<Crew>> getCrewsByDoubleCharMap(Crews allCrews) {
        Map<String, Set<Crew>> crewsByDoubleCharMap = new HashMap<>();

        allCrews.getCrews().forEach(crew -> {
            String nickname = crew.getNickname();

            for (int nicknameIdx = 0; nicknameIdx < nickname.length() - 1; nicknameIdx++) {
                String doubleChar = nickname.charAt(nicknameIdx) + "" + nickname.charAt(nicknameIdx + 1);

                crewsByDoubleCharMap.putIfAbsent(doubleChar, new HashSet<>());
                crewsByDoubleCharMap.get(doubleChar).add(crew);
            }
        });

        return crewsByDoubleCharMap;
    }

    public Set<Crew> getDuplicatedCrews(Crews allCrews) {
        Map<String, Set<Crew>> crewsByDoubleCharMap = getCrewsByDoubleCharMap(allCrews);

        // 두글자:[이메일]를 순회하며 크루의 개수가 2개 이상인 것을 찾음
        return crewsByDoubleCharMap.values().stream()
                .filter(crews -> crews.size() >= 2)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
