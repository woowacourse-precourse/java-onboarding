package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class NicknameCheckService {

    // 같은 글자가 연속으로 포함된 경우 닉네임 사용 제한.
    public List<String> getDuplicateCrewEmail(List<Crew> crewList) {
        List<String> result = new ArrayList<>();

        Map<String, Integer> countOfCase = getCountOfCase(getAllCase(crewList), crewList);
        List<String> duplicatedCase = getDuplicatedCase(countOfCase);

        for (String cases : duplicatedCase) {
            crewList.stream()
                    .filter(crew -> crew.getNickname().contains(cases))
                    .forEach(crew -> result.add(crew.getEmail()));
        }

        Collections.sort(result);
        return result;
    }

    // 유저 닉네임에 대한 경우의 수를 구하는 로직.
    private Set<String> getCases(String nickname) {
        Set<String> results = new HashSet<>();

        // 닉네임을 2글자씩 자른다.
        for (int idx = 0; idx < nickname.length() - 1; idx++) {
            String substring = nickname.substring(idx, idx + 2);
            results.add(substring);
        }

        return results;
    }

    // 모든 경우의 수를 Set 형태로 반환.
    private Set<String> getAllCase(List<Crew> crewList) {
        Set<String> set = new HashSet<>();
        crewList.forEach(crew -> set.addAll(getCases(crew.getNickname())));

        return set;
    }

    // 경우의 수와 크루 목록을 이용해서 경우의 수가 크루에 포함될 경우 카운트 -> 경우의 수=카운트 형태의 맵 반환.
    private Map<String, Integer> getCountOfCase(Set<String> allCase, List<Crew> crewList) {
        Map<String, Integer> result = new HashMap<>();
        for (String cases : allCase) {
            int count = (int) crewList.stream()
                    .filter(crew -> crew.getNickname().contains(cases))
                    .count();

            result.put(cases, count);
        }

        return result;
    }

    // 카운트가 2 이상인 경우의 수만 얻어내는 로직.
    private List<String> getDuplicatedCase(Map<String, Integer> countOfCase) {
        return countOfCase.entrySet().stream()
                .filter(cases -> cases.getValue() >= 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
