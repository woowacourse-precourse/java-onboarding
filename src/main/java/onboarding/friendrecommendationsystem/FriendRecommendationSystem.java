package onboarding.friendrecommendationsystem;

import static onboarding.friendrecommendationsystem.RecommendationRule.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FriendRecommendationSystem {
	
	private static final int RECOMMEND_USER_LIMIT = 5;

	private final String user;

	private final Map<String, List<String>> friendMap;

	private final Map<String, Integer> recommendScore;

	public FriendRecommendationSystem(String user,
		List<List<String>> friends,
		List<String> visitors) {

		this.user = user;
		this.friendMap = new HashMap<>();
		this.recommendScore = new HashMap<>();

		initUserFriends(friends);
		initVisitorScore(visitors);
		initKnowWithUserScore();
	}

	private void initUserFriends(final List<List<String>> friends) {
		for (List<String> friend : friends) {
			initUserFriend(friend);
		}
	}

	private void initUserFriend(final List<String> friend) {
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

	private void initVisitorScore(final List<String> visitors) {
		int point = getPointOf(VISITOR);
		for (String visitor : visitors) {
			recommendScore.merge(visitor, point,
				(score, ignored) -> score + point);
		}
	}

	private void initKnowWithUserScore() {
		int point = getPointOf(KNOW_WITH_USER);
		for (String friend : friendMap.keySet()) {
			int numberOfFriends = getNumberOfFriendsKnowWith(friend);

			if (numberOfFriends != 0) {
				recommendScore.merge(friend, point,
					(score, ignored) -> score + numberOfFriends * point);
			}
		}
	}

	int getNumberOfFriendsKnowWith(final String other) {
		if (user.equals(other)) {
			return 0;
		}
		return (int)friendMap.get(other)
			.stream()
			.filter(this::isUserFriend)
			.count();
	}

	private boolean isUserFriend(final String friend) {
		return friendMap.get(user).contains(friend);
	}

	public List<String> getRecommendedUsers() {
		return recommendScore.keySet()
			.stream()
			.filter(this::isFriendToRecommend)
			.sorted(this::compareScore)
			.limit(RECOMMEND_USER_LIMIT)
			.collect(Collectors.toList());
	}

	private boolean isFriendToRecommend(String other) {
		return !isUserFriend(other)
			&& recommendScore.get(other) != 0;
	}

	private int compareScore(String s1, String s2) {
		int s1Score = recommendScore.get(s1);
		int s2Score = recommendScore.get(s2);

		if (s1Score == s2Score) {
			return s1.compareTo(s2);
		}
		return s2Score - s1Score;
	}
}
