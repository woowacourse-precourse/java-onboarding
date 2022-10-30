package onboarding.problem6.solver;

import onboarding.problem.Solver;
import onboarding.problem6.domain.Crew;
import onboarding.problem6.domain.NicknameChecker;
import onboarding.problem6.input.Problem6Input;
import onboarding.problem6.result.Problem6Result;

import java.util.List;
import java.util.Set;

public class Problem6Solver implements Solver<Problem6Input, Problem6Result> {

    private final NicknameChecker checker = new NicknameChecker();

    @Override
    public Problem6Result solve(Problem6Input input) {
        List<Crew> crews = input.crews();

        Set<Crew> crewsWithDuplicatedNickname
                = checker.findCrewsWithDuplicatedNickname(crews);

        return new Problem6Result(crewsWithDuplicatedNickname);
    }
}
