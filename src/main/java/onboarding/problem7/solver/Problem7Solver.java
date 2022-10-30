package onboarding.problem7.solver;

import onboarding.problem.Solver;
import onboarding.problem7.domain.Recommend;
import onboarding.problem7.domain.Recommender;
import onboarding.problem7.domain.User;
import onboarding.problem7.input.Problem7Input;
import onboarding.problem7.result.Problem7Result;

import java.util.List;

public class Problem7Solver implements Solver<Problem7Input, Problem7Result> {

	@Override
	public Problem7Result solve(Problem7Input input) {
		User user = input.user();
		Recommender recommender = new Recommender();

		List<Recommend> recommends = recommender.recommend(user);
		return new Problem7Result(recommends);
	}
}
