package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
	private static final int SAME_FRIEND_SCORE = 10;
	private static final int VISIT_SCORE = 1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, Set<String>> friendMapSet = mapByFriendMapSet(friends);
		Map<String, Integer> friendScore = getSameFriendScore(friendMapSet, user);
		Map<String, Integer> visitorScore = getVisitScore(friendMapSet, visitors, user);
		Map<String, Integer> finalScore = getFinalScore(friendScore, visitorScore);

		List<String> answer = new ArrayList<>(finalScore.keySet());
		answer.sort((o1, o2) -> {
			if (finalScore.get(o1) < finalScore.get(o2)) {
				return 1;
			} else if (finalScore.get(o1) > finalScore.get(o2)) {
				return -1;
			}
			return 0;
		});

		return answer.stream().limit(5).collect(Collectors.toList());
	}

	private static Map<String, Integer> getFinalScore(Map<String, Integer> friendScore,
		Map<String, Integer> visitorScore) {
		Map<String, Integer> score = new HashMap<>();

		for (String name : friendScore.keySet()) {
			score.put(name, friendScore.getOrDefault(name, 0));
		}

		for (String name : visitorScore.keySet()) {
			score.put(name, visitorScore.getOrDefault(name, 0));
		}

		return score;
	}

	private static Map<String, Integer> getVisitScore(Map<String, Set<String>> friendMapSet, List<String> visitors,
		String user) {
		Map<String, Integer> score = new HashMap<>();
		for (String name : visitors) {
			// 나 또는 이미 친구는 넘겨
			if (name.equals(user) || friendMapSet.get(user).contains(name)) {
				continue;
			}
			score.put(name, score.getOrDefault(name, 0) + VISIT_SCORE);
		}
		return score;
	}

	private static Map<String, Integer> getSameFriendScore(Map<String, Set<String>> friendMapSet, String user) {
		Map<String, Integer> score = new HashMap<>();
		for (String name : friendMapSet.keySet()) {
			// 나 또는 이미 친구는 넘겨
			if (name.equals(user) || friendMapSet.get(user).contains(name)) {
				continue;
			}
			// 함께 아는 친구수 구하기
			int sameFriend = getSameFriendCount(user, name, friendMapSet);
			score.put(name, sameFriend * SAME_FRIEND_SCORE);
		}
		return score;
	}

	private static int getSameFriendCount(String user, String friend, Map<String, Set<String>> friendMapSet) {
		int count = 0;
		for (String name : friendMapSet.get(friend)) {
			if (friendMapSet.get(user).contains(name)) {
				count++;
			}
		}
		return count;
	}

	private static Map<String, Set<String>> mapByFriendMapSet(List<List<String>> friends) {
		Map<String, Set<String>> friendMapSet = new HashMap<>();

		for (List<String> friend : friends) {
			String friendA = friend.get(0);
			String friendB = friend.get(1);

			friendMapSet.putIfAbsent(friendA, new HashSet<>());
			friendMapSet.get(friendA).add(friendB);

			friendMapSet.putIfAbsent(friendB, new HashSet<>());
			friendMapSet.get(friendB).add(friendA);
		}
		return friendMapSet;
	}

}
