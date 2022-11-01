package onboarding.problem7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Friends {

	private final Visit visit;
	private final Map<String, List<String>> friends;

	public Friends(List<List<String>> relationships, List<String> visitors) {
		Map<String, List<String>> friends = new HashMap<>();
		for (List<String> relationship : relationships) {
			String friend = relationship.get(0);
			String otherFriend = relationship.get(1);
			friends.putIfAbsent(friend, new ArrayList<>());
			friends.putIfAbsent(otherFriend, new ArrayList<>());
			friends.get(friend).add(otherFriend);
			friends.get(otherFriend).add(friend);

			friends.get(friend).add(friend);
			friends.get(otherFriend).add(otherFriend);
		}
		this.friends = friends;
		this.visit = new Visit(visitors);
	}

	public boolean isTwoFriends(String user, String other) {
		return friends.get(user).contains(other);
	}

	public int countSharedFriends(String user, String other) {
		List<String> userFriends = friends.get(user);
		List<String> otherUserFriends = friends.get(other);
		if (userFriends == null || otherUserFriends == null) {
			return 0;
		}

		int count = 0;
		for (String otherUserFriend : otherUserFriends) {
			if (userFriends.contains(otherUserFriend)) {
				count += 1;
			}
		}
		return count;
	}

	public Set<String> getKnownUsers() {
		Set<String> knownUsers = new HashSet<>();
		knownUsers.addAll(friends.keySet());
		knownUsers.addAll(visit.getVisitors());
		return knownUsers;
	}

	public int calculateScoreOf(String user, String friend) {
		int sharedFriendsCount = countSharedFriends(user, friend);
		int visitCount = visit.count(friend);
		return sharedFriendsCount * 10 + visitCount;
	}

	public Collection<String> recommendFriendsFor(String user) {
		Map<String, Integer> scores = new TreeMap<>();
		for (String friend : getKnownUsers()) {
			if (isTwoFriends(user, friend)) {
				continue;
			}
			scores.put(friend, calculateScoreOf(user, friend));
		}
		return scores.keySet();
	}
}
