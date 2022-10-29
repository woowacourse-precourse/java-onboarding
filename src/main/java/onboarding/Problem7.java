package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem7 {
	private static final int FRIEND_SCORE = 10;
	private static final int VISIT_SCORE = 1;
	private static final int MAX_RECOMMEND_FRIEND = 5;
	private static final int LEFT_FRIEND_INDEX = 0;
	private static final int RIGHT_FRIEND_INDEX = 1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, List<String>> userList = new HashMap<>();
		userList.putAll(addVisitUser(visitors));
		userList.putAll(addUser(friends));

		Map<String, Integer> userScore = new HashMap<>();

		for (String systemUser : userList.keySet()) {
			userScore.put(systemUser, FRIEND_SCORE * addFriendScore(userList.get(user), userList.get(systemUser)));
		}
		userScore.putAll(addVisitScore(userScore, visitors));
		List<Entry<String, Integer>> recommendFriendList = sortRecommendFriend(userScore);
		return makeRecommendFriendList(user, userList, recommendFriendList);
	}

	private static Map<String, List<String>> addVisitUser(List<String> visitors) {
		Map<String, List<String>> userList = new HashMap<>();
		for (String visitor : visitors) {
			userList.put(visitor, new ArrayList<>());
		}
		return userList;
	}

	private static Map<String, List<String>> addUser(List<List<String>> friends) {
		Map<String, List<String>> userList = new HashMap<>();
		for (List<String> friend : friends) {
			String leftFriend = friend.get(LEFT_FRIEND_INDEX);
			String rightFriend = friend.get(RIGHT_FRIEND_INDEX);
			if (userList.containsKey(leftFriend)) {
				userList.get(leftFriend).add(rightFriend);
			} else {
				userList.put(leftFriend, new ArrayList<>(List.of(rightFriend)));
			}
			if (userList.containsKey(rightFriend)) {
				userList.get(rightFriend).add(leftFriend);
			} else {
				userList.put(rightFriend, new ArrayList<>(List.of(leftFriend)));
			}
		}
		return userList;
	}

	private static int addFriendScore(List<String> userFriends, List<String> systemUserFriends) {
		return (int)systemUserFriends.stream().filter(userFriends::contains).count();
	}

	private static Map<String, Integer> addVisitScore(Map<String, Integer> scoreList, List<String> visitors) {
		for (String visitor : visitors) {
			scoreList.put(visitor, VISIT_SCORE);
		}
		return scoreList;
	}

	private static List<Entry<String, Integer>> sortRecommendFriend(Map<String, Integer> userScore) {
		List<Entry<String, Integer>> recommendFriendList = new ArrayList<>(userScore.entrySet());
		recommendFriendList.sort((o1, o2) -> {
			if (o1.getValue().equals(o2.getValue())) {
				return o1.getKey().compareTo(o2.getKey());
			}
			return o2.getValue().compareTo(o1.getValue());
		});
		return recommendFriendList;
	}

	private static List<String> makeRecommendFriendList(String user, Map<String, List<String>> userList,
		List<Entry<String, Integer>> recommendFriend) {
		return recommendFriend.stream()
			.filter(key -> !user.equals(key.getKey()))
			.filter(key -> !userList.get(user).contains(key.getKey()))
			.filter(value -> value.getValue() != 0)
			.map(Entry::getKey)
			.limit(MAX_RECOMMEND_FRIEND)
			.collect(Collectors.toList());
	}
}
