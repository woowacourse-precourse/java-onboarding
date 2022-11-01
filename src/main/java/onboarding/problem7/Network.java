package onboarding.problem7;

import java.util.Collection;
import java.util.List;

public class Network {
	private final FriendsUpper friends;

	public Network(List<List<String>> relationships, List<String> visitors) {
		this.friends = new FriendsUpper(relationships, visitors);
	}

	public Collection<String> recommendFriends(String user) {
		return friends.recommendFriendsFor(user);
	}
}
