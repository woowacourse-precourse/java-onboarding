package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class Crews {
    public List<String> findNotCrews(List<List<String>> forms) {
        TreeSet<Crew> notCrewTree= new TreeSet<>(getTemp(forms));

        return notCrewTree.stream()
                .map(Crew::getEmail)
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<Crew> getTemp(List<List<String>> forms) {
        return forms.stream()
                .map(Crew::new)
                .sorted()
                .collect(Collectors.toList());
    }

}
