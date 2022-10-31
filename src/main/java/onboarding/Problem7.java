package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = new ArrayList<>();
		List<String> userFriends = new ArrayList<>();
		Map<String, Integer> friendScore = new HashMap<>();
		findUserFriend(friends, userFriends, user);
		calcFriendsScore(user, friendScore, friends, userFriends);
		calcVisitorScore(visitors, friendScore);

		List<Entry<String, Integer>> entries = new ArrayList<>(friendScore.entrySet());
		sortScore(entries);

		return answer;
	}

	public static void findUserFriend(List<List<String>> friends, List<String> userFriends, String user) {
		for (List<String> friend : friends) {
			String A = friend.get(0);
			String B = friend.get(1);
			if (A.equals(user)) {
				userFriends.add(B);
			}
			if (B.equals(user)) {
				userFriends.add(A);
			}
		}
	}

	public static void calcFriendsScore(String user, Map<String, Integer> friendScore, List<List<String>> friends,
		List<String> userFriends) {
		for (List<String> friend : friends) {
			String friendA = friend.get(0);
			String friendB = friend.get(1);
			if (isFriendsFriend(user, friendA, friendB, userFriends)) {
				friendScore.put(friendB, friendScore.getOrDefault(friendB, 10) + 10);
			}
			if (isFriendsFriend(user, friendB, friendA, userFriends)) {
				friendScore.put(friendA, friendScore.getOrDefault(friendA, 10) + 10);
			}
		}
	}

	public static boolean isFriendsFriend(String user, String friendA, String friendB, List<String> userFriends) {
		return userFriends.contains(friendA) && !friendB.equals(user);
	}

	public static void calcVisitorScore(List<String> visitors, Map<String, Integer> friendScore) {
		for (String visitor : visitors) {
			friendScore.put(visitor, friendScore.getOrDefault(visitor, 0) + 1);
		}
	}

	public static void sortScore(List<Entry<String, Integer>> entries) {
		entries.sort((o1, o2) -> {
			if (Objects.equals(o1.getValue(), o2.getValue())) {
				return o1.getKey().compareTo(o2.getKey());
			}
			return o2.getValue().compareTo(o1.getValue());
		});
	}

	public static void recommendFriend() {

	}
}
