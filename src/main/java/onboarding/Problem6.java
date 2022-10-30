package onboarding;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> nickNamesFromForms = getNickNamesFromForms(forms);

        return answer;
    }

    static List<String> getNickNamesFromForms(List<List<String>> forms) {
        return forms.stream()
                .flatMap(Collection::stream)
                .filter(form -> form.matches("^[가-힣]*$"))
                .collect(Collectors.toList());
    }
}
