package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ScoreCalculatorImp {
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

	private Map<String, Integer> getVisitScoreMap(String user, List<String> visitors) {
		Map<String, Integer> visitorScoreMap = new HashMap<>();
		visitors.forEach(visitor -> {
			visitorScoreMap.merge(visitor, 1, Integer::sum);
		});
		return visitorScoreMap;
	}
}
