package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
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
