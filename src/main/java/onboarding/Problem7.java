package onboarding;

import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import onboarding.problem7.SNSSystem;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		SNSSystem snsSystem = new SNSSystem();
		for (List<String> friend : friends) {
			snsSystem.add(friend);
		}
		HashMap<String, Integer> resultList = getStringIntegerHashMap(user, snsSystem);
		return getRecommendationList(user, visitors, snsSystem, resultList);
	}

	private static HashMap<String, Integer> getStringIntegerHashMap(String user, SNSSystem snsSystem) {
		List<String> secondFriends = snsSystem.getSecondFriends(user);
		HashMap<String, Integer> resultList = new HashMap<>();
		for (String secondFriend : secondFriends) {
			resultList.put(secondFriend, 10);
		}
		return resultList;
	}

	private static List<String> getRecommendationList(String user, List<String> visitors, SNSSystem snsSystem,
		HashMap<String, Integer> resultList) {
		List<String> visitorList = visitors.stream().
			filter(visitor -> !snsSystem.isFriends(user, visitor))
			.collect(toList());
		extracted(resultList, visitorList);
		return getCollect(resultList);
	}

	private static void extracted(HashMap<String, Integer> resultList, List<String> visitorList) {
		for (String visitor : visitorList) {
			if (resultList.containsKey(visitor)) {
				resultList.replace(visitor, resultList.get(visitor) + 1);
			} else {
				resultList.put(visitor, 1);
			}
		}
	}

	private static List<String> getCollect(HashMap<String, Integer> resultList) {
		return resultList.entrySet()
			.stream()
			.sorted(getEntryComparator())
			.limit(5)
			.map(Map.Entry::getKey)
			.collect(toList());
	}

	private static Comparator<Map.Entry<String, Integer>> getEntryComparator() {
		return (o1, o2) -> {
			if (o1.getValue().equals(o2.getValue())) {
				return o1.getKey().compareTo(o2.getKey());
			}
			return Integer.compare(o2.getValue(), o1.getValue());
		};
	}
}
