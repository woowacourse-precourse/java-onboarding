package onboarding.problem7;

import java.util.List;
import java.util.Map;

public class RecommendController {
	private final ScoreCalculator scoreCalculator;
	private final RankingGetter rankingGetter;

	public RecommendController(ScoreCalculator scoreCalculator, RankingGetter rankingGetter) {
		this.scoreCalculator = scoreCalculator;
		this.rankingGetter = rankingGetter;
	}

	public List<String> recommend(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, Integer> scoreMap = scoreCalculator.getScoreMap(user, friends, visitors);
		List<String> recommendRanking = rankingGetter.getRecommendRanking(scoreMap, 5);
		return recommendRanking;
	}
}
