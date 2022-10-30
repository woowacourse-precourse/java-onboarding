package onboarding.friendrecommendationsystem;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FriendRecommendationSystem {

	private final String user;

	private Map<String, List<String>> friendMap;

	private Map<String, Integer> scoreMap;

	public FriendRecommendationSystem(String user,
		List<List<String>> friends,
		List<String> visitors) {

		this.user = user;
		initUsersWith(friends);
		initRecommendationScoreWith(visitors);
	}

	private void initRecommendationScoreWith(final List<String> visitors) {
		this.scoreMap = new HashMap<>();
		for (String friend : friendMap.keySet()) {
			scoreMap.put(friend, 0);
		}
		for (String visitor : visitors) {
			scoreMap.merge(visitor, 0,
				(score, ignored) -> score + 1);
		}
	}

	private void initUsersWith(final List<List<String>> friends) {
		this.friendMap = new HashMap<>();
		for (List<String> friend : friends) {
			initUserWith(friend);
		}
	}

	private void initUserWith(List<String> friend) {
		String friendA = friend.get(0);
		String friendB = friend.get(1);

		friendMap.merge(friendA, List.of(friendB),
			FriendRecommendationSystem::concatList);
		friendMap.merge(friendB, List.of(friendA),
			FriendRecommendationSystem::concatList);
	}

	private static List<String> concatList(List<String> fr1, List<String> fr2) {
		return Stream.of(fr1, fr2)
			.flatMap(Collection::stream)
			.collect(Collectors.toList());
	}

	public List<String> getFriendsOf(final String user) {
		return friendMap.getOrDefault(user, Collections.emptyList());
	}
}
