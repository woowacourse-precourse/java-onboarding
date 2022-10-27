package onboarding;

import java.util.*;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		HashMap<String, Integer> recommendFriends = new HashMap<>();
		Set<String> userFriends = new HashSet<>();

		for (List<String> friend : friends) {
			String idA = friend.get(0);
			String idB = friend.get(1);
			userFriends.add(idA);
			if (idB.equals(user)) {
				continue;
			}
			increaseRecommendScore(recommendFriends, idB);
		}

		for (String visitor : visitors) {
			if (userFriends.contains(visitor)) {
				continue;
			}
			increaseVisitorScore(recommendFriends, visitor);
		}

		System.out.println(recommendFriends);

		return Collections.emptyList();
	}

	private static void increaseVisitorScore(HashMap<String, Integer> recommendFriends, String id) {
		if (recommendFriends.containsKey(id)) {
			recommendFriends.put(id, recommendFriends.get(id) + 1);
		} else {
			recommendFriends.put(id, 1);
		}
	}

	private static void increaseRecommendScore(HashMap<String, Integer> recommendFriends, String id) {
		if (recommendFriends.containsKey(id)) {
			recommendFriends.put(id, recommendFriends.get(id) + 10);
		} else {
			recommendFriends.put(id, 10);
		}
	}
}
