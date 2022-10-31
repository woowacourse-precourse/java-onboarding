package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
	private static final Set<String> userFriends = new HashSet<>();
	private static final Map<String, Score> nicknameWithScore = new HashMap<>();

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		findUserFriend(user, friends);
		calculateOverlappedFriendScore(friends);
		calculateFeedVisitorScore(visitors);

		List<Score> sortedScores = new ArrayList<>(nicknameWithScore.values());
		Collections.sort(sortedScores);

		List<String> answer = new ArrayList<>();
		for (int i = 0; i < 5 && i < sortedScores.size(); i++) {
			answer.add(sortedScores.get(i).name);
		}
		return answer;
	}

	private static void findUserFriend(String user, List<List<String>> friends) {
		userFriends.add(user); // 자기 자신도 친구에 포함 시켜서, 자신을 추천하지 않도록 한다.
		for (List<String> friend : friends) {
			String a = friend.get(0);
			String b = friend.get(1);

			if (user.equals(a)) {
				userFriends.add(b);
			} else if (user.equals(b)) {
				userFriends.add(a);
			}
		}
	}

	private static void calculateOverlappedFriendScore(List<List<String>> friends) {
		for (List<String> friend : friends) {
			String a = friend.get(0);
			String b = friend.get(1);

			if (userFriends.contains(a) && !userFriends.contains(b)) {
				addOverlappedFriend(b);
			} else if (userFriends.contains(b) && !userFriends.contains(a)) {
				addOverlappedFriend(a);
			}
		}
	}

	private static void addOverlappedFriend(String overlapped) {
		Score score = nicknameWithScore.getOrDefault(overlapped, new Score(overlapped));
		score.addOverlapFriendCount();
		nicknameWithScore.put(overlapped, score);
	}

	private static void calculateFeedVisitorScore(List<String> visitors) {
		for (String visitor : visitors) {
			if (userFriends.contains(visitor)) {
				continue;
			}
			Score score = nicknameWithScore.getOrDefault(visitor, new Score(visitor));
			score.addVisitedCount();
			nicknameWithScore.put(visitor, score);
		}
	}

	static class Score implements Comparable<Score> {
		String name;
		int overlapFriendCount;
		int visitedCount;

		public Score(String name) {
			this.name = name;
			this.overlapFriendCount = 0;
			this.visitedCount = 0;
		}

		public int calculateTotalScore() {
			return overlapFriendCount * 10 + visitedCount;
		}

		public void addOverlapFriendCount() {
			this.overlapFriendCount++;
		}

		public void addVisitedCount() {
			this.visitedCount++;
		}

		@Override
		public int compareTo(Score o) {
			// 점수가 같은 경우 이름 순으로 정렬되도록 한다.
			if (this.calculateTotalScore() == o.calculateTotalScore()) {
				return this.name.compareTo(o.name);
			}
			// 점수를 기준으로 내림차순으로 정렬되도록 한다.
			return Integer.compare(o.calculateTotalScore(), this.calculateTotalScore());
		}
	}
}
