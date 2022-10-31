package onboarding.problem7;

import java.util.List;
import java.util.Map;

public interface RankingGetter {
	public List<String> getFriendsRanking(Map<String, Integer> scoreMap, int limitValue);
}
