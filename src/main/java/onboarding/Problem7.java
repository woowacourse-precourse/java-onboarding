package onboarding;

import java.util.*;
import java.util.stream.Collectors;

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

		return recommendFriends.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
						.thenComparing(Map.Entry.comparingByKey()))
				.limit(5)
				.filter(recommendFriend -> recommendFriend.getValue() != 0)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
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
