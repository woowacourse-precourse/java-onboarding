package onboarding.problem7.result;

import onboarding.problem.ProblemResult;
import onboarding.problem7.domain.Recommend;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;

public class Problem7Result implements ProblemResult<List<String>> {

    private static final int RESULT_LIMIT = 5;

    List<Recommend> recommends;

    public Problem7Result(List<Recommend> recommends) {
        this.recommends = recommends;
    }

    @Override
    public List<String> toResult() {
        return recommends.stream()
                .sorted(naturalOrder())
                .map(r -> r.getRecommendUser().getName())
                .limit(RESULT_LIMIT)
                .collect(Collectors.toList());
    }
}
