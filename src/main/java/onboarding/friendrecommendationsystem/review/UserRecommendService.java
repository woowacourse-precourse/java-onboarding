package onboarding.friendrecommendationsystem.review;

import static onboarding.friendrecommendationsystem.review.RecommendScore.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRecommendService {

	private static final long RECOMMEND_LIMIT = 5;

	private final Users users;

	private final Map<User, Integer> scores;

	public UserRecommendService(final Users users) {
		this.users = users;
		this.scores = new HashMap<>();
	}

	public List<String> recommendFriends(final String userId,
		final List<String> visitors) {

		User user = users.getUserById(userId);
		calculateScore(userId, visitors);

		return scores.keySet()
			.stream()
			.filter(other -> !user.isFriendWith(other))
			.filter(other -> scores.get(other) != 0)
			.sorted(this::compareUser)
			.map(User::getId)
			.limit(RECOMMEND_LIMIT)
			.collect(Collectors.toList());
	}

	private void calculateScore(final String userId,
		final List<String> visitors) {

		scores.clear();
		calculateKnowWithScore(userId);
		calculateVisitorsScore(visitors);
	}

	public void calculateKnowWithScore(final String userId) {
		User user = users.getUserById(userId);
		int score = KNOW_WITH_USER.getScore();

		for (User other : users) {
			if (!other.equals(user)) {
				int numberOfFriends = other.getNumberOfFriendsKnowWith(user);
				scores.put(other, numberOfFriends * score);
			}
		}
	}

	private void calculateVisitorsScore(final List<String> visitors) {
		for (String visitorId : visitors) {
			calculateVisitorScore(visitorId);
		}
	}

	private void calculateVisitorScore(String visitorId) {
		User visitor = users.getUserById(visitorId);
		int score = VISITOR.getScore();

		if (visitor == null) {
			visitor = new User(visitorId);
		}
		scores.put(visitor,
			scores.getOrDefault(visitor, 0) + score);
	}

	private int compareUser(User userA, User userB) {
		int compareResult = Integer.compare(
			scores.get(userB),
			scores.get(userA));

		if (compareResult == 0) {
			return userA.compareTo(userB);
		}
		return compareResult;
	}
}
