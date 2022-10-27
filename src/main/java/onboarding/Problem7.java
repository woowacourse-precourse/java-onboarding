package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
	private static final int FRIEND_SCORE = 10;
	private static final int VISIT_SCORE = 1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, List<String>> userList = new HashMap<>();

		for (String visitor : visitors) {
			userList.put(visitor, new ArrayList<>());
		}
		for (List<String> friend : friends) {
			if (userList.containsKey(friend.get(0))) {
				userList.get(friend.get(0)).add(friend.get(1));
			} else {
				userList.put(friend.get(0), new ArrayList<>(List.of(friend.get(1))));
			}

			if (userList.containsKey(friend.get(1))) {
				userList.get(friend.get(1)).add(friend.get(0));
			} else {
				userList.put(friend.get(1), new ArrayList<>(List.of(friend.get(0))));
			}
		}

		return new ArrayList<>();
	}
}
