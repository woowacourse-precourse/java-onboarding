package onboarding.problem6.finder;

import onboarding.problem6.crew.Crew;

import java.util.List;

public interface CrewFinder {
    List<String> findCrews(List<Crew> crews);
}
