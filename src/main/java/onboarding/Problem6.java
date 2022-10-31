package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<Crew> crews = allCrews(forms);
        List<Crew> answer = duplicateCrews(crews);
        return distinct(answer);
    }

    private static List<Crew> allCrews(List<List<String>> forms) {
        return forms.stream()
                .map(form -> new Crew(form.get(0), form.get(1)))
                .collect(Collectors.toList());
    }

    private static List<Crew> duplicateCrews(List<Crew> crews) {
        return crews.stream()
                .map(crew -> duplicateCrews(crew, crews))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private static List<Crew> duplicateCrews(Crew crew, List<Crew> crews) {
        List<Crew> duplicateCrews = crews.stream()
                .filter(it -> it.duplicate(crew))
                .collect(Collectors.toList());

        if (duplicateCrews.isEmpty()) {
            return duplicateCrews;
        }
        duplicateCrews.add(crew);
        return duplicateCrews;
    }

    private static List<String> distinct(List<Crew> answer) {
        return answer.stream()
                .map(Crew::getEmail)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
