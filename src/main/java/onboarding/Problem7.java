package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {

	static Map<String, Integer> recommendationScore = new HashMap<>();

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> existingFriends = new ArrayList<>();
		List<String> newFriends = new ArrayList<>();

		for (List<String> friend : friends) {
			filterExistFriend(user, friend, existingFriends);
		}

		for (String friend : existingFriends) {
			List<String> list = filterNewFriends(friend, user, friends);
			newFriends.addAll(list);
		}

		for (String newFriend : newFriends) {
			scoreFriends(newFriend, 10);
		}

		for (String visitor : visitors) {
			if (existingFriends.contains(visitor))
				continue;
			scoreFriends(visitor, 1);
		}

		return selectTopFivePeople(recommendationScore);

	}

	public static void filterExistFriend(String user, List<String> friend, List<String> existingFriendList) {
		if (friend.contains(user)) {
			String friendName = friend.stream()
				.filter(friendFilter -> !friendFilter.equals(user))
				.findFirst().orElseThrow();
			existingFriendList.add(friendName);
		}
	}

	public static List<String> filterNewFriends(String friend, String user, List<List<String>> friends) {
		return friends.stream()
			.filter(friendList -> friendList.contains(friend) && !friendList.contains(user))
			.flatMap(Collection::stream)
			.filter(f -> !f.equals(friend))
			.collect(Collectors.toList());
	}

	//점수 추가 로직
	public static void scoreFriends(String account, int point) {
		if (recommendationScore.containsKey(account)) {
			int score = recommendationScore.get(account);
			recommendationScore.replace(account, score + point);
			return;
		}
		recommendationScore.put(account, point);
	}

	public static List<String> selectTopFivePeople(Map<String, Integer> recommendationScore) {
		List<String> result = recommendationScore.entrySet().stream()
			.sorted((o1, o2) -> {
				if (o1.getValue().equals(o2.getValue())) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return o2.getValue() - o1.getValue();
			})
			.limit(5)
			.map(Map.Entry::getKey)
			.collect(Collectors.toList());

		return result;
	}
}