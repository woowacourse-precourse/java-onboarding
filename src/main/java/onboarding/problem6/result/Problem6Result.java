package onboarding.problem6.result;

import onboarding.problem.ProblemResult;
import onboarding.problem6.domain.Crew;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;

public class Problem6Result implements ProblemResult<List<String>> {

    private final Set<Crew> crewSet;

    public Problem6Result(Set<Crew> crewsWithDuplicatedNickname) {
        this.crewSet = crewsWithDuplicatedNickname;
    }

    @Override
    public List<String> toResult() {
        return crewSet.stream()
                .map(Crew::getFullEmail)
                .sorted(naturalOrder())
                .collect(Collectors.toList());
    }
}
