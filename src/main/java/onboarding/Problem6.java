package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {

    private static final Map<String, String> crewInfoMap = new HashMap<>();

    public static List<String> solution(List<List<String>> crewInfoForms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void initCrewInfoMap(List<List<String>> crewForms) {
        crewForms.stream()
                .forEach(crewInfo -> {
                    String crewNickname = crewInfo.get(1);
                    String crewEmail = crewInfo.get(0);
                    crewInfoMap.put(crewNickname, crewEmail);
                });
    }

}
