package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = new ArrayList<>();
		List<String> userFriends = new ArrayList<>();
		Map<String, Integer> friendScore = new HashMap<>();
		findUserFriend(friends, userFriends, user);
		calcFriendsScore(friendScore, friends, userFriends);
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

	public static void calcFriendsScore(Map<String, Integer> friendScore, List<List<String>> friends,
		List<String> userFriends) {

	}

	public static void sortScore() {

	}

	public static void recommendFriend() {

	}
}
