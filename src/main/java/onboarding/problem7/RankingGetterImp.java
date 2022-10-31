package onboarding.problem7;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankingGetterImp implements RankingGetter {
	@Override
	public List<String> getRecommendRanking(Map<String, Integer> scoreMap, int limitValue) {
		List<String> ranking = scoreMap.entrySet().stream()
			.sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
				.thenComparing(Map.Entry.comparingByKey()))
			.limit(limitValue)
			.map(Map.Entry::getKey)
			.collect(Collectors.toList());
		return ranking;
	}
}
