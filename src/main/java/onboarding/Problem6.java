package onboarding;

import onboarding.problem6.Crew;
import onboarding.problem6.Crews;
import onboarding.problem6.DuplicatedCrewsFinder;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static Crews createCrews(List<List<String>> forms) {
        return new Crews(forms.stream()
                .map(emailNickname -> new Crew(emailNickname.get(0), emailNickname.get(1)))
                .collect(Collectors.toList()));
    }

    public static List<String> solution(List<List<String>> forms) {
        validateForms(forms);
        Crews crews = createCrews(forms);

        DuplicatedCrewsFinder duplicatedCrewsFinder = new DuplicatedCrewsFinder();
        Set<Crew> duplicatedCrews = duplicatedCrewsFinder.getDuplicatedCrews(crews);

        return duplicatedCrews.stream()
                .map(Crew::getEmail)
                .sorted()
                .collect(Collectors.toList());
    }

    private static void validateForms(List<List<String>> forms) throws IllegalArgumentException {
        if (!forms.stream().allMatch(form -> form.size() == 2)) {
            throw new IllegalArgumentException("forms의 형식이 잘못되었습니다: forms안의 배열은 크기가 2여야 합니다.");
        }
    }
}
