package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		HashMap<String, Integer> recommendFriends = new HashMap<>();
		for (List<String> friend : friends) {
			if (friend.get(1).equals(user)) {
				continue;
			}

			if (recommendFriends.containsKey(friend.get(1))) {
				recommendFriends.put(friend.get(1), recommendFriends.get(friend.get(1)) + 10);
			} else {
				recommendFriends.put(friend.get(1), 10);
			}
		}

		for (String visitor : visitors) {
			if (recommendFriends.containsKey(visitor)) {
				recommendFriends.put(visitor, recommendFriends.get(visitor) + 1);
			} else {
				recommendFriends.put(visitor, 1);
			}
		}
		System.out.println(recommendFriends);

		return Collections.emptyList();
	}
}
