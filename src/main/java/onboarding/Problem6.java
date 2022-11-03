package onboarding;

import onboarding.problem6.Crew;
import onboarding.problem6.Crews;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Crews crews = new Crews(forms.stream()
                .map(form -> new Crew(form.get(0), form.get(1)))
                .collect(Collectors.toList()));
        return crews.getDuplicatedCrewEmailList();
    }
}
