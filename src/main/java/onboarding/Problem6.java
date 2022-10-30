package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<Crew> crews = allCrews(forms);
        List<String> answer = List.of("answer");
        return answer;
    }

    private static List<Crew> allCrews(List<List<String>> forms) {
        return forms.stream()
                .map(form -> new Crew(form.get(0), form.get(1)))
                .collect(Collectors.toList());
    }
}
