package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
	static class Score implements Comparable<Score> {
		String userId;
		int score;

		public Score(String userId, int score) {
			this.userId = userId;
			this.score = score;
		}

		@Override
		public int compareTo(Score o) {
			if (o.score == this.score) {
				return this.userId.compareTo(o.userId);
			}
			return o.score - this.score;
		}
	}

	private static final Map<String, Set<String>> friendInfo = new HashMap<>();
	private static final Map<String, Integer> scoreMap = new HashMap<>();

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		validateUser(user);
		collectFriendInfos(friends);
		scoringFriends(user);
		scoringVisits(visitors);
		return getResultList(user);
	}

	private static List<String> getResultList(String user) {
		return scoreMap.entrySet().stream()
			.map(entry -> new Score(entry.getKey(), entry.getValue()))
			.sorted()
			.filter(sc -> sc.score > 0 && !friendInfo.get(user).contains(sc.userId))
			.limit(5)
			.map(sc -> sc.userId)
			.collect(Collectors.toList());
	}

	private static void collectFriendInfos(List<List<String>> friends) {
		for (List<String> friend : friends) {
			String user1 = friend.get(0);
			String user2 = friend.get(1);
			validateUser(user1);
			validateUser(user2);
			if (!friendInfo.containsKey(user1)) {
				friendInfo.put(user1, new HashSet<>());
			}
			if (!friendInfo.containsKey(user2)) {
				friendInfo.put(user2, new HashSet<>());
			}
			friendInfo.get(user1).add(user2);
			friendInfo.get(user2).add(user1);
		}
	}

	private static void scoringFriends(String user) {
		Set<String> userFriends = friendInfo.get(user);
		for (Map.Entry<String, Set<String>> info : friendInfo.entrySet()) {
			if (info.getKey().equals(user)) {
				continue;
			}
			info.getValue().stream()
				.filter(userFriends::contains)
				.forEach(s -> scoreMap.put(info.getKey(), scoreMap.getOrDefault(info.getKey(), 0) + 10));
		}
	}

	private static void scoringVisits(List<String> visitors) {
		visitors.forEach(visitor -> scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1));
	}

	private static void validateUser(String user) {
		if (user.length() < 1 || user.length() > 30) {
			throw new IllegalArgumentException("아이디는 길이가 1이상 30이하여야합니다.");
		}
		if (!user.chars().allMatch(c -> Character.isLowerCase((char)c))) {
			throw new IllegalArgumentException("아이디는 알파벳 소문자여야합니다.");
		}
	}
}
