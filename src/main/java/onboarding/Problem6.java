package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    static Map<String, String> crews = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        initialCrews(forms);
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void initialCrews(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            List<String> crew = forms.get(i);
            crews.put(crew.get(1), crew.get(0));
        }
    }
}
