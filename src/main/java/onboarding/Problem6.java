package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static Map<String, String> listToMap(List<List<String>> forms) {
        Map<String, String> formsMap = new HashMap<>();
        for(List<String> form: forms) {
            formsMap.put(form.get(1), form.get(0));
        }
        return formsMap;
    }

}