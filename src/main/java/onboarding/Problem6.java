package onboarding;

import onboarding.problem6.Crew;
import onboarding.problem6.DuplicatedCrewsFinder;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<Crew> createCrews(List<List<String>> forms) {
        return forms.stream()
                .map(emailNickname -> new Crew(emailNickname.get(0), emailNickname.get(1)))
                .collect(Collectors.toList());
    }

    public static List<String> solution(List<List<String>> forms) {
        List<Crew> crews = createCrews(forms);

        DuplicatedCrewsFinder duplicatedCrewsFinder = new DuplicatedCrewsFinder();
        Set<Crew> duplicatedCrews = duplicatedCrewsFinder.getDuplicatedCrews(crews);

        return duplicatedCrews.stream()
                .map(Crew::getEmail)
                .sorted()
                .collect(Collectors.toList());
    }
}
