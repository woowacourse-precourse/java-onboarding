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
		List<String> answer = Collections.emptyList();
		Set<String> userFriends = new HashSet<>();
		Map<String, Integer> friendScore = new HashMap<>();
		for (int i = 0; i < friends.size(); i++) {
			String idA = friends.get(i).get(0);
			String idB = friends.get(i).get(1);
			if (idA == user) {
				userFriends.add(idB);
			} else if (idB == user) {
				userFriends.add(idA);
			}
		}
		for (int i = 0; i < friends.size(); i++) {
			String idA = friends.get(i).get(0);
			String idB = friends.get(i).get(1);
			if (userFriends.contains(idA) && !userFriends.contains(idB)) {
				friendScore.put(idB, friendScore.getOrDefault(idB, 0) + 10);
			} else if (userFriends.contains(idB) && !userFriends.contains(idA)) {
				friendScore.put(idA, friendScore.getOrDefault(idA, 0) + 10);
			}
		}
		for (int i = 0; i < visitors.size(); i++) {
			String visitor = visitors.get(i);
			if (!userFriends.contains(visitor)) {
				friendScore.put(visitor, friendScore.getOrDefault(visitor, 0) + 1);
			}
		}
		friendScore.put(user, 0);
		while (friendScore.size() < PERSON_NUM_SHOW) {
			friendScore.put("emptyUser", 0);
		}
		List<Map.Entry<String, Integer>> sortedFriendScore = new ArrayList<>(friendScore.entrySet());
		sortedFriendScore.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		return answer;
	}
}
