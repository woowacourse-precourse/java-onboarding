package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> crewInfo = new HashMap<>();
        List<String> answer = new ArrayList<>();

        forms.forEach(form ->
                crewInfo.put(form.get(1), form.get(0))
        );

        return answer;
    }
    

}
