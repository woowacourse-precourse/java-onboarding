package onboarding.problem7;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Network {

	private static final int SHARED_FRIEND_SCORE_MULTIPLIER = 10;
	private static final int RECOMMENDATION_MAX_SIZE = 5;

	private final Visitors visitors;
	private final Relationships relationships;

	public Network(List<List<String>> relationships, List<String> visitors) {
		this.relationships = new Relationships(relationships);
		this.visitors = new Visitors(visitors);
	}

	public Collection<String> recommendFriendsFor(String user) {
		Set<RecommendedFriend> recommendedFriends = new TreeSet<>(Comparator.reverseOrder());
		for (String friend : getKnownUsers()) {
			if (relationships.isTwoFriends(user, friend)) {
				continue;
			}
			recommendedFriends.add(new RecommendedFriend(friend, calculateScoreOf(user, friend)));
		}
		return limitFiveFriendNames(recommendedFriends);
	}

	private List<String> limitFiveFriendNames(Set<RecommendedFriend> recommendedFriends) {
		return recommendedFriends
			.stream()
			.map(RecommendedFriend::getName)
			.limit(RECOMMENDATION_MAX_SIZE)
			.collect(Collectors.toUnmodifiableList());
	}

	private int calculateScoreOf(String user, String friend) {
		int sharedFriendsCount = relationships.countSharedFriends(user, friend);
		int visitCount = visitors.countVisit(friend);
		return sharedFriendsCount * SHARED_FRIEND_SCORE_MULTIPLIER + visitCount;
	}

	private Set<String> getKnownUsers() {
		Set<String> knownUsers = new HashSet<>();
		knownUsers.addAll(relationships.getKnownUsers());
		knownUsers.addAll(visitors.getKnownUsers());
		return knownUsers;
	}
}
