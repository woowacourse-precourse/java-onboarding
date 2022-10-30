package onboarding.problem6;

import static onboarding.problem6.consts.FormIndexConst.FORM_EMAIL_INDEX;
import static onboarding.problem6.consts.FormIndexConst.FORM_NICKNAME_INDEX;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CrewRepository {

    private final List<Crew> crews;

    public CrewRepository(List<List<String>> forms) {
        this.crews = initCrews(forms);
    }

    private List<Crew> initCrews(List<List<String>> forms) {
        return forms.stream()
            .map(crew -> new Crew(crew.get(FORM_EMAIL_INDEX), crew.get(FORM_NICKNAME_INDEX)))
            .collect(Collectors.toList());
    }

    public Stream<Crew> findAllCrewStream() {
        return crews.stream();
    }
}
