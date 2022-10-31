package onboarding.friendrecommendationsystem;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FriendRecommendationSystem {

	private static final int RULE_ONE_POINT = 10;

	private static final int RULE_TWO_POINT = 1;

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

	private void initRecommendationScoreWith(final List<String> visitors) {
		this.scoreMap = new HashMap<>();
		for (String friend : friendMap.keySet()) {
			if (!user.equals(friend)) {
				scoreMap.put(friend, 0);
			}
		}
		for (String visitor : visitors) {
			scoreMap.merge(visitor, RULE_TWO_POINT,
				(score, ignored) -> score + RULE_TWO_POINT);
		}
	}

	int getNumberOfFriendsKnowWith(final String other) {
		if (user.equals(other)) {
			return 0;
		}
		int numberOfFriends = 0;
		for (String friend : getFriendsOf(other)) {
			if (checkUserContains(friend)) {
				numberOfFriends++;
			}
		}
		return numberOfFriends;
	}

	List<String> getFriendsOf(final String user) {
		return friendMap.getOrDefault(user, Collections.emptyList());
	}

	private boolean checkUserContains(final String friend) {
		return !user.equals(friend)
			&& getFriendsOf(user).contains(friend);
	}

	public List<String> getRecommendationUsers() {
		return scoreMap.keySet()
			.stream()
			.filter(other -> !checkUserContains(other))
			.sorted(this::compare)
			.collect(Collectors.toList());
	}

	private int compare(String s1, String s2) {
		int s1Score = getRecommendationScore(s1);
		int s2Score = getRecommendationScore(s2);

		if (s1Score == s2Score) {
			return s1.compareTo(s2);
		}
		return s2Score - s1Score;
	}

	public int getRecommendationScore(final String other) {
		return getNumberOfFriendsKnowWith(other) * RULE_ONE_POINT
			+ scoreMap.get(other);
	}
}
