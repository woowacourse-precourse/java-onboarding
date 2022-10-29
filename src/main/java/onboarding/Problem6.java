package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, String> crew = getCrewMap(forms);
        return answer;
    }

    private static Map<String, String> getCrewMap(List<List<String>> forms) {
        Map<String, String> crew = new HashMap<>();
        forms.forEach(i -> crew.put(i.get(1), i.get(0)));
        return crew;
    }
}
