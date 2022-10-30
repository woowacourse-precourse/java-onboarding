package onboarding;

import onboarding.problem6.Crew;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<Crew> createCrews(List<List<String>> forms) {
        return forms.stream()
                .map(emailNickname -> new Crew(emailNickname.get(0), emailNickname.get(1)))
                .collect(Collectors.toList());
    }

    public static Map<String, Set<Crew>> getCrewsByDoubleCharMap(List<Crew> allCrews) {
        Map<String, Set<Crew>> crewsByDoubleCharMap = new HashMap<>();

        allCrews.forEach(crew -> {
            String nickname = crew.getNickname();

            for (int nicknameIdx = 0; nicknameIdx < nickname.length() - 1; nicknameIdx++) {
                String doubleChar = nickname.charAt(nicknameIdx) + "" + nickname.charAt(nicknameIdx + 1);

                crewsByDoubleCharMap.getOrDefault(doubleChar, new HashSet<>()).add(crew);
            }
        });

        return crewsByDoubleCharMap;
    }

    public static Set<Crew> getDuplicatedCrews(List<Crew> allCrews) {
        Map<String, Set<Crew>> crewsByDoubleCharMap = getCrewsByDoubleCharMap(allCrews);

        // 두글자:[이메일]를 순회하며 이메일의 개수가 2개 이상인 것을 찾음
        Set<Crew> duplicatedCrews = new HashSet<>();
        crewsByDoubleCharMap.values().stream()
                .filter(crews -> crews.size() >= 2)
                .forEach(duplicatedCrews::addAll);

        return duplicatedCrews;
    }

    public static <T> List<T> getSortedListBySet(Set<T> set) {
        return set.stream().sorted().collect(Collectors.toList());
    }

    public static List<String> solution(List<List<String>> forms) {
        List<Crew> crews = createCrews(forms);

        Set<Crew> duplicatedCrewsSet = getDuplicatedCrews(crews);
        List<Crew> duplicatedCrews = getSortedListBySet(duplicatedCrewsSet);

        return duplicatedCrews.stream()
                .map(Crew::getEmail)
                .collect(Collectors.toList());
    }
}
