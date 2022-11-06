package onboarding.friendrecommendationsystem;

import java.util.function.Function;

public enum RecommendationRule {
	KNOW_WITH_USER(10, (score) -> score + 10),
	VISITOR(1, (score) -> score + 1);

	private final int point;

	private final Function<Integer, Integer> func;

	RecommendationRule(int point, Function<Integer, Integer> func) {
		this.point = point;
		this.func = func;
	}

	public static int getPointOf(final RecommendationRule rule) {
		return rule.func.apply(rule.point);
	}
}
