package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, Integer> userList = new HashMap<>();
		List<String> userFriendList = new ArrayList<>();

		for (List<String> friend : friends) {
			userList.put(friend.get(0), 0);
			userList.put(friend.get(1), 0);

			if (friend.get(0).equals(user)) {
				userFriendList.add(friend.get(1));
			} else if (friend.get(1).equals(user)) {
				userFriendList.add(friend.get(0));
			}
		}
		return new ArrayList<>();
	}
}
