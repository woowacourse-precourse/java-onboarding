package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

          List<Crew> crewList = forms.stream()
                .map(Crew::toCrew)
                .collect(Collectors.toList());

        Map<String, List<Crew>> crewMap = makeNicknameMap(crewList);

        return getOverlapCrew(crewMap);
    }

    private static Map<String, List<Crew>> makeNicknameMap(List<Crew> crews) {

        Map<String, List<Crew>> crewMap = new HashMap<>();

        for (Crew crew : crews) {
            String nickname = crew.getNickname();
            for (int i = 0; i < nickname.length() - 1; i++) {
                String twoCharacter = nickname.substring(i, i + 2);
                crewMap.putIfAbsent(twoCharacter, new ArrayList<>());
                crewMap.get(twoCharacter).add(crew);
            }
        }
        return crewMap;
    }

    private static List<String> getOverlapCrew(Map<String, List<Crew>> crewMap) {
        List<String> overlapCrew = crewMap.values().stream()
                .filter(value -> value.size() > 1)
                .flatMap(Collection::stream)
                .map(Crew::getEmail)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        return overlapCrew;
    }
}

class Crew {

    private String email;
    private String nickname;

    public Crew(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public static Crew toCrew(List<String> form) {
        return new Crew(form.get(0), form.get(1));
    }
}
