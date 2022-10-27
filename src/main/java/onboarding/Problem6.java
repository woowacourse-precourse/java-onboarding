package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        if (forms.size() < 1 || forms.size() > 10000) {
            return Collections.emptyList();
        }
        
        return answer;
    }
}
