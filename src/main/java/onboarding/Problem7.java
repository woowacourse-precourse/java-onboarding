package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Problem7 {
	static HashMap<String, List<String>> friendList = new HashMap<>();
	static HashMap<String, Integer> distanceMap = new HashMap<>();
	static List<String> mutualFriends = new ArrayList<>();
	static HashMap<String, Integer> scoreMap = new HashMap<>();

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();
		String mate1;
		String mate2;
		for (List<String> mate : friends) {
			mate1 = mate.get(0);
			mate2 = mate.get(1);
			makeGraph(mate1, mate2);
		}

		findDistance(user);
		System.out.println("distanceMap = " + distanceMap);
		choiceMutualFriends();
		System.out.println("mutualFriends = " + mutualFriends);
		countKnowFriends();
		System.out.println("scoreMap = " + scoreMap);

		countFeedVisitors(visitors);
		System.out.println("scoreMap = " + scoreMap);

		// scoreMap 정렬 (1. 값큰수 / 2. 키 이름순)
		// 정렬후 큰거부터 5개뽑기
		// 리펙토링 -> 우선순위 큐
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
		System.out.println("friendList = " + friendList);
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
			System.out.println("visitor = " + visitor);
			if (distanceMap.containsKey(visitor)) {
				if (distanceMap.get(visitor) == 1) {    // 이미친구
					continue;
				}
				if (!scoreMap.containsKey(visitor)) {    // 거리:2이상친구
					scoreMap.put(visitor, 1);
					continue;
				}
				scoreMap.put(visitor, scoreMap.get(visitor) + 1);    // 함께아는 친구
			}
			if (scoreMap.containsKey(visitor)) {
				scoreMap.put(visitor, scoreMap.get(visitor) + 1);    // 난생처음보는데 또 피드본 친구
				continue;
			}
			scoreMap.put(visitor, 1);    // 난생처음보는 친구
		}
	}

	public static void main(String[] args) {
		String user = "mrko";
		List<List<String>> friends = List.of(
			List.of("donut", "andole"),
			List.of("donut", "jun"),
			List.of("donut", "mrko"),
			List.of("shakevan", "andole"),
			List.of("shakevan", "jun"),
			List.of("shakevan", "mrko")
		);
		List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
		solution(user, friends, visitors);
	}
}
