package onboarding.problemseven.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sns {

	private HashMap<String, List<String>> friendMap = new HashMap<>();

	public Sns(List<List<String>> friends) {
		for (List<String> friend : friends) {
			String userA = friend.get(0);
			String userB = friend.get(1);

			addFriend(userA, userB);
			addFriend(userB, userA);
		}
	}

	private void addFriend(String userA, String userB) {
		if (friendMap.containsKey(userA)) {
			friendMap.get(userA).add(userB);
		} else if (!friendMap.containsKey(userA)) {
			List<String> friendList = new ArrayList<>();
			friendList.add(userB);
			friendMap.put(userA, friendList);
		}
	}

	public List<String> recommendFriend(String me, List<String> visitors) {
		HashMap<String, Integer> scoreBoard = new HashMap<>();

		for (String userA : friendMap.keySet()) {
			if (!userA.equals(me)) {
				friendToScore(me, userA, scoreBoard);
			}
		}

		visitorsToScore(visitors, scoreBoard);

		removeFriend(me, scoreBoard);

		return sorteMap(scoreBoard);
	}

	private List<String> sorteMap(HashMap<String, Integer> map) {
		List<String> collect = map.entrySet()
			.stream()
			.filter(e -> e.getValue() != 0)
			.sorted(Collections
				.reverseOrder(
					Map.Entry.<String, Integer>comparingByValue())
				.thenComparing(Map.Entry.comparingByKey()))
			.map(Map.Entry<String, Integer>::getKey)
			.limit(5)
			.collect(Collectors.toList());

		return collect;
	}

	private void removeFriend(String me, HashMap<String, Integer> scoreBoard) {
		if(friendMap.get(me)==null )
			return;

		List<String> friendList = friendMap.get(me);
		for (String friend : friendList) {
			scoreBoard.remove(friend);
		}
	}

	private void friendToScore(String me, String userA, HashMap<String, Integer> scoreBoard) {

		if(friendMap.get(me)==null || friendMap.get(userA)==null)
			return;

		List<String> friendListA = friendMap.get(me);
		List<String> friendListB = friendMap.get(userA);

		int friendCnt = 0;

		for (String friend : friendListA) {
			if (friendListB.contains(friend)) {
				friendCnt += 1;
			}
		}
		scoreBoard.put(userA, friendCnt * 10);

	}

	private void visitorsToScore(List<String> visitors, HashMap<String, Integer> scoreBoard) {
		for (String visitor : visitors) {
			if (scoreBoard.containsKey(visitor)) {
				int score = scoreBoard.get(visitor);
				scoreBoard.put(visitor, score + 1);
			} else if (!scoreBoard.containsKey(visitor)) {
				scoreBoard.put(visitor, 1);
			}
		}
	}
}
