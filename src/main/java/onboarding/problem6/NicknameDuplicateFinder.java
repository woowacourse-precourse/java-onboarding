package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class NicknameDuplicateFinder {
    public static List<Email> find(List<Crew> crewList) {
        Map<String, List<Crew>> crewsIncludeLetters = new HashMap<>();
        Set<Crew> result = new HashSet<>();

        for (Crew crew : crewList) {
            String nickname = crew.getNickname().getValue();
            //nickname을 두글자씩 쪼갠다
            for (int i = 0; i < nickname.length() - 1; i++) {
                String letters = nickname.substring(i, i + 2); // 아하, 배열 크기가 3이면 substring(0,3)까지는 할 수 있구나 실제로는 0,1,2만 가져가니까
                if (!crewsIncludeLetters.containsKey(letters)) {
                    crewsIncludeLetters.put(letters, new ArrayList<>(List.of(crew)));
                } else {
                    crewsIncludeLetters.get(letters).add(crew);
                }
            }
        }
        for (String letter : crewsIncludeLetters.keySet()) {
            if (crewsIncludeLetters.get(letter).size()>1) {
                result.addAll(crewsIncludeLetters.get(letter));
            }
        }
        return result.stream().map(crew -> crew.getEmail()).collect(Collectors.toList());
    }
}
