package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
	private static final int PERSON_NUM_SHOW = 5;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = new ArrayList<>(Collections.emptyList());
		Set<String> userFriends = findUserFriends(user, friends);
		HashMap<String, Integer> friendsScore = new HashMap<>();
		addSharedFriendsScore(friends, userFriends, friendsScore);

		for (int i = 0; i < visitors.size(); i++) {
			String visitor = visitors.get(i);
			if (!userFriends.contains(visitor)) {
				friendsScore.put(visitor, friendsScore.getOrDefault(visitor, 0) + 1);
			}
		}
		friendsScore.put(user, 0);
		while (friendsScore.size() < PERSON_NUM_SHOW) {
			friendsScore.put("emptyUser", 0);
		}
		List<Map.Entry<String, Integer>> sortedFriendScore = new ArrayList<>(friendsScore.entrySet());
		sortedFriendScore.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for (int i = 0; i < PERSON_NUM_SHOW; i++) {
			String name = sortedFriendScore.get(i).getKey();
			Integer score = sortedFriendScore.get(i).getValue();
			if (score > 0) {
				answer.add(name);
			}
		}
		return answer;
	}

	private static HashSet<String> findUserFriends(String user, List<List<String>> friends) {
		HashSet<String> userFriends = new HashSet<>();
		for (List<String> friend : friends) {
			String idA = friend.get(0);
			String idB = friend.get(1);
			if (idA.equals(user)) {
				userFriends.add(idB);
			} else if (idB.equals(user)) {
				userFriends.add(idA);
			}
		}
		return userFriends;
	}

	private static void addSharedFriendsScore(List<List<String>> friends,
		Set<String> userFriends, HashMap<String, Integer> friendsScore) {
		for (List<String> friend : friends) {
			String idA = friend.get(0);
			String idB = friend.get(1);
			if (userFriends.contains(idA)) {
				friendsScore.put(idB, friendsScore.getOrDefault(idB, 0) + 10);
			} else if (userFriends.contains(idB)) {
				friendsScore.put(idA, friendsScore.getOrDefault(idA, 0) + 10);
			}
		}
	}
}
