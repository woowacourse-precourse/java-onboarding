package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
	private static final int FRIEND_SCORE = 10;
	private static final int VISIT_SCORE = 1;
	private static final int MAX_RECOMMEND_FRIEND = 5;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, List<String>> userList = new HashMap<>();
		Map<String, Integer> userScore = new HashMap<>();

		for (String visitor : visitors) {
			userList.put(visitor, new ArrayList<>());
		}
		for (List<String> friend : friends) {
			if (userList.containsKey(friend.get(0))) {
				userList.get(friend.get(0)).add(friend.get(1));
			} else {
				userList.put(friend.get(0), new ArrayList<>(List.of(friend.get(1))));
			}

			if (userList.containsKey(friend.get(1))) {
				userList.get(friend.get(1)).add(friend.get(0));
			} else {
				userList.put(friend.get(1), new ArrayList<>(List.of(friend.get(0))));
			}
		}
		for (String systemUser : userList.keySet()) {
			userScore.put(systemUser, 0);
		}

		for (String systemUser : userList.keySet()) {
			if (userList.get(user).contains(systemUser)) {
				continue;
			}

			for (String userFriend : userList.get(systemUser)) {
				if (userList.get(user).contains(userFriend)) {
					userScore.put(systemUser, userScore.get(systemUser) + FRIEND_SCORE);
				}
			}
		}

		for (String visitor : visitors) {
			userScore.put(visitor, userScore.get(visitor) + VISIT_SCORE);
		}

		List<Map.Entry<String, Integer>> recommendFriendList = new ArrayList<>(userScore.entrySet());
		recommendFriendList.sort((o1, o2) -> {
			if (o1.getValue().equals(o2.getValue())) {
				return o1.getKey().compareTo(o2.getKey());
			}
			return o2.getValue().compareTo(o1.getValue());
		});

		List<String> result = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : recommendFriendList) {
			if (user.equals(entry.getKey()) || userList.get(user).contains(entry.getKey())) {
				continue;
			}
			if (result.size() > MAX_RECOMMEND_FRIEND || entry.getValue() == 0) {
				break;
			}
			result.add(entry.getKey());
		}
		return result;
	}
}
