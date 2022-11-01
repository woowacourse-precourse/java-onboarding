package onboarding.problem7;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Network {

	private final Visitors visitors;
	private final Friends friends;

	public Network(List<List<String>> relationships, List<String> visitors) {
		this.friends = new Friends(relationships);
		this.visitors = new Visitors(visitors);
	}

	public Collection<String> recommendFriendsFor(String user) {
		Map<String, Integer> scores = new TreeMap<>();
		for (String friend : getKnownUsers()) {
			if (friends.isTwoFriends(user, friend)) {
				continue;
			}
			scores.put(friend, calculateScoreOf(user, friend));
		}
		return scores.keySet();
	}

	private int calculateScoreOf(String user, String friend) {
		int sharedFriendsCount = friends.countSharedFriends(user, friend);
		int visitCount = visitors.count(friend);
		return sharedFriendsCount * 10 + visitCount;
	}

	private Set<String> getKnownUsers() {
		Set<String> knownUsers = new HashSet<>();
		knownUsers.addAll(friends.getKnownUsers());
		knownUsers.addAll(visitors.getKnownUsers());
		return knownUsers;
	}
}
