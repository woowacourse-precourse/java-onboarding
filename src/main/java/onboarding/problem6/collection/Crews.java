package onboarding.problem6.collection;

import onboarding.problem6.domain.Crew;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Crews {
    private final List<Crew> crews;

    public Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public Set<Crew> getCrewSetOverlappingWith(Crew crew) {
        return crews.stream()
                .filter(x -> !x.equals(crew))
                .filter(x -> x.isOverlappedWith(crew))
                .collect(Collectors.toSet());
    }

    public List<Crew> getCrewListWithOverlappingNickname() {
        Set<Crew> set = new HashSet<>();
        for (Crew crew : crews) {
            set.addAll(getCrewSetOverlappingWith(crew));
        }
        return List.copyOf(set);
    }
}
