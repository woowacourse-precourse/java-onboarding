package onboarding.problem7;

import java.util.List;
import java.util.Map;

public interface ScoreCalculator {
	public Map<String, Integer> getScoreMap(String user, List<List<String>> friends, List<String> visitors);
}
