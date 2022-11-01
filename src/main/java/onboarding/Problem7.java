package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class Problem7 {
	static HashMap<String, List<String>> friendList;
	static HashMap<String, Integer> distanceMap;
	static List<String> mutualFriends;
	static HashMap<String, Integer> scoreMap;
	static List<Map.Entry<String, Integer>> scoreList;
	static List<String> answer;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		friendList = new HashMap<>();
		distanceMap = new HashMap<>();
		mutualFriends = new ArrayList<>();
		scoreMap = new HashMap<>();
		answer = new ArrayList<>();
		String mate1;
		String mate2;
		for (List<String> mate : friends) {
			mate1 = mate.get(0);
			mate2 = mate.get(1);
			makeGraph(mate1, mate2);
		}

		findDistance(user);
		choiceMutualFriends();
		countKnowFriends();
		countFeedVisitors(visitors);
		sortScores();
		int count = 0;
		for (Map.Entry<String, Integer> entry : scoreList) {
			if (count == 5) {
				break;
			}
			answer.add(entry.getKey());
			count++;
		}
		return answer;
	}

	public static void makeGraph(String mate1, String mate2) {
		String firstMate;
		String secondMate;
		for (int i = 0; i < 2; i++) {
			firstMate = i == 0 ? mate1 : mate2;
			secondMate = i == 0 ? mate2 : mate1;
			if (!friendList.containsKey(firstMate)) {
				friendList.put(firstMate, new ArrayList<>());
			}
			friendList.get(firstMate).add(secondMate);
		}
	}

	public static void findDistance(String root) {
		Queue<String> queue = new LinkedList<>();
		queue.add(root);
		distanceMap.put(root, 0);
		while (!queue.isEmpty()) {
			String curMember = queue.poll();
			for (String anotherMember : friendList.get(curMember)) {
				if (distanceMap.containsKey(anotherMember)) {
					continue;
				}
				queue.add(anotherMember);
				distanceMap.put(anotherMember, distanceMap.get(curMember) + 1);
			}
		}
	}

	public static void countKnowFriends() {
		for (String mate : mutualFriends) {
			for (String closeMate : friendList.get(mate)) {
				if (distanceMap.get(closeMate) == 1) {
					if (!scoreMap.containsKey(mate)) {
						scoreMap.put(mate, 10);
						continue;
					}
					scoreMap.put(mate, scoreMap.get(mate) + 10);
				}
			}
		}
	}

	public static void choiceMutualFriends() {
		Set<Map.Entry<String, Integer>> entrySet = distanceMap.entrySet();
		for (Map.Entry<String, Integer> entry : entrySet) {
			if (entry.getValue() == 2) {
				mutualFriends.add(entry.getKey());
			}
		}
	}

	public static void countFeedVisitors(List<String> visitors) {
		for (String visitor : visitors) {
			if (distanceMap.containsKey(visitor)) {
				if (distanceMap.get(visitor) <= 1) {    // 이미친구거나 자신
					continue;
				}
				if (!scoreMap.containsKey(visitor)) {    // 거리:2이상친구
					scoreMap.put(visitor, 1);
					continue;
				}
				scoreMap.put(visitor, scoreMap.get(visitor) + 1);    // 함께아는 친구
				continue;
			}
			if (scoreMap.containsKey(visitor)) {
				scoreMap.put(visitor, scoreMap.get(visitor) + 1);    // 난생처음보는데 또 피드본 친구
				continue;
			}
			scoreMap.put(visitor, 1);    // 난생처음보는 친구
		}
	}

	public static void sortScores() {
		scoreList = new ArrayList<>(scoreMap.entrySet());
		scoreList.sort((o1, o2) -> {
			if (Objects.equals(o1.getValue(), o2.getValue())) {
				return o1.getKey().compareTo(o2.getKey());
			}
			return o2.getValue() - o1.getValue();
		});
	}
}
