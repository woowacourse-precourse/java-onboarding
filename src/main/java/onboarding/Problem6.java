package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    private static final Map<String, String> crewInfoMap = new HashMap<>();

    public static List<String> solution(List<List<String>> crewInfoForms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public void initCrewInfoMap(List<List<String>> crewForms) {
        crewForms.stream()
                .forEach(crewInfo -> {
                    String crewEmail = crewInfo.get(0);
                    String crewNickname = crewInfo.get(1);
                    crewInfoMap.put(crewEmail, crewNickname);
                });
    }
}
