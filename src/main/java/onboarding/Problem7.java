package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
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
			if (userFriends.contains(idA)) {
				friendScore.put(idB, friendScore.getOrDefault(idB, 0) + 10);
			} else if (userFriends.contains(idB)) {
				friendScore.put(idA, friendScore.getOrDefault(idA, 0) + 10);
			}
		}
		
		return answer;
	}
}
