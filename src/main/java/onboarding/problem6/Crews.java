package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {
    List<Crew> crews;

    public Crews(List<List<String>> forms) {
        crews = forms.stream()
                .map((list) -> new Crew(list.get(0), list.get(1)))
                .collect(Collectors.toList());
    }

    public Crews() {
        this.crews = new ArrayList<>();
    }

    public List<Crew> getCrews() {
        return this.crews;
    }

    public void add(Crew crew) {
        this.crews.add(crew);
    }
}
