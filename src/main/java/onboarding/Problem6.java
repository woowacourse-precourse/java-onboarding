package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, String> crew_list = new HashMap<>();
        HashSet<String> email_list = new HashSet<>();
        for (List<String> crew : forms) {
            crew_list.put(crew.get(0), crew.get(1));
        }
        return answer;
    }
}
