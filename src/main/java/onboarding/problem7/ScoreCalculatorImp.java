package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class ScoreCalculatorImp implements ScoreCalculator {
	private Map<String, List<String>> getFriendMap(List<List<String>> friends) {
		Map<String, List<String>> friendMap = new HashMap<>();
		friends.forEach(friend -> {
			IntStream.range(0, 2).forEachOrdered(i -> {
				friendMap.computeIfAbsent(friend.get(i), e -> new ArrayList<>()).add(friend.get(1 - i));
			});
		});
		return friendMap;
	}

	private Map<String, Integer> getFriendScoreMap(String user, Map<String, List<String>> friendMap) {
		Map<String, Integer> friendScoreMap = new HashMap<>();
		friendMap.keySet().forEach(name -> {
			friendMap.get(name).forEach(friendName -> {
				if (friendMap.get(friendName).contains(user)) {
					friendScoreMap.merge(name, 10, Integer::sum);
				}
			});
		});
		return friendScoreMap;
	}

	private Map<String, Integer> getVisitorScoreMap(List<String> visitors) {
		Map<String, Integer> visitorScoreMap = new HashMap<>();
		visitors.forEach(visitor -> {
			visitorScoreMap.merge(visitor, 1, Integer::sum);
		});
		return visitorScoreMap;
	}

	private Map<String, Integer> mergeScoreMaps(Map<String, Integer> scoreMap1, Map<String, Integer> scoreMap2) {
		scoreMap2.forEach((key, value) -> scoreMap1.merge(key, value, Integer::sum));
		return scoreMap1;
	}

	private Map<String, Integer> getValidScoreMap(String user, Map<String, Integer> scoreMap,
		Map<String, List<String>> friendMap) {
		Set<String> names = scoreMap.keySet();
		List<String> removeKeys = new ArrayList<>();
		for (String name : names) {
			if (friendMap.get(user).contains(name) || user.equals(name)) {
				removeKeys.add(name);
			}
		}
		scoreMap.entrySet().removeIf(e -> removeKeys.contains(e.getKey()));
		return scoreMap;
	}

	@Override
	public Map<String, Integer> getScoreMap(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, List<String>> friendMap = getFriendMap(friends);
		Map<String, Integer> friendScoreMap = getFriendScoreMap(user, friendMap);
		Map<String, Integer> visitorScoreMap = getVisitorScoreMap(visitors);
		Map<String, Integer> scoreMap = mergeScoreMaps(friendScoreMap, visitorScoreMap);
		return getValidScoreMap(user, scoreMap, friendMap);
	}
}
