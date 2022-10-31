package onboarding.problem7;

import java.util.List;
import java.util.Map;

public interface RankingGetter {
	public List<String> getRecommendRanking(Map<String, Integer> scoreMap, int limitValue);
}
