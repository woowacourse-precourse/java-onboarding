package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> crewInfo = new HashMap<>();

        initializationCrewInfo(forms, crewInfo);

        return answer;
    }

    private static void initializationCrewInfo(List<List<String>> forms,
                                               Map<String, String> crewInfo) {
        for (List<String> form : forms) {
            String nickname = form.get(1);
            String email = form.get(0);

            crewInfo.put(nickname, email);
        }
    }
}
