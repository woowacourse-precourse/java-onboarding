package onboarding.problem7;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Network {
	private final Friends friends;

	public Network(List<List<String>> relationships, List<String> visitors) {
		this.friends = new Friends(relationships, visitors);
	}

	public Collection<String> recommendFriends(String user) {
		return friends.recommendFriendsFor(user);
	}
}
