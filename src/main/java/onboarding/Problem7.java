package onboarding;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Problem7 {
	public static final int RECOMMEND_SCORE = 10;
	public static final int VISITOR_SCORE = 1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, Integer> recommendFriends = new HashMap<>();
		Set<String> userFriends = new HashSet<>();

		for (List<String> friend : friends) {
			String idA = friend.get(0);
			String idB = friend.get(1);
			if (idA.equals(user)) {
				userFriends.add(idB);
			} else if (idB.equals(user)) {
				userFriends.add(idA);
			}
		}

		for (List<String> friend : friends) {
			String idA = friend.get(0);
			String idB = friend.get(1);

			if (idA.equals(user) || idB.equals(user)) {
				continue;
			}

			for (String userFriend : userFriends) {
				if (userFriend.equals(idA)) {
					addRecommendFriendScore(recommendFriends, idB);
				} else if (userFriend.equals(idB)) {
					addRecommendFriendScore(recommendFriends, idA);
				}
			}
		}

		for (String visitor : visitors) {
			if (userFriends.contains(visitor)) {
				continue;
			}
			addVisitorScore(recommendFriends, visitor);
		}

		return recommendFriends.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
						.thenComparing(Map.Entry.comparingByKey()))
				.limit(5)
				.map(Map.Entry::getKey)
				.collect(toList());
	}

	private static void addVisitorScore(Map<String, Integer> recommendFriends, String id) {
		if (recommendFriends.containsKey(id)) {
			recommendFriends.put(id, recommendFriends.get(id) + VISITOR_SCORE);
		} else {
			recommendFriends.put(id, VISITOR_SCORE);
		}
	}

	private static void addRecommendFriendScore(Map<String, Integer> recommendFriends, String id) {
		if (recommendFriends.containsKey(id)) {
			recommendFriends.put(id, recommendFriends.get(id) + RECOMMEND_SCORE);
		} else {
			recommendFriends.put(id, RECOMMEND_SCORE);
		}
	}
}
