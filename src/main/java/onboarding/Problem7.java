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

	}

	public static void calcFriendsScore(Map<String, Integer> friendScore, List<List<String>> friends,
		List<String> userFriends) {

	}

	public static void sortScore() {

	}

	public static void recommendFriend() {
		
	}
}
