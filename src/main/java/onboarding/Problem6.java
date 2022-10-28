package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> form = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            List a = forms.get(i);
            form.put((String) a.get(0), (String) a.get(1));
        }

        List<String> answer = List.of("answer");
        return answer;
    }
}
