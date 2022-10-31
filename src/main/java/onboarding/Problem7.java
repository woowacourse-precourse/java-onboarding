package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

		List<String> userFriends = getUserFriends(user, friends);
		Map<String, Integer> map = getUserFriendsOfFriends(user, friends, userFriends);
		getVisitorPoint(visitors, userFriends, map);

		List<String> answer = new ArrayList<>(map.keySet());
		sortByValue(map, answer);

		return answer(answer);
	}

	private static List<String> answer(List<String> answer) {
		if (answer.size() > 5) {
			return answer.subList(0, 5);
		}
		return answer;
	}

	private static void sortByValue(Map<String, Integer> map, List<String> answer) {
		answer.sort((o1, o2) -> {
			if (map.get(o2) - map.get(o1) == 0) {
				return o1.compareTo(o2);
			}
			return map.get(o2) - map.get(o1);
		});
	}

	private static void getVisitorPoint(List<String> visitors, List<String> userFriends, Map<String, Integer> map) {
		for (String visitor : visitors) {
			if (!userFriends.contains(visitor)) {
				if (!map.containsKey(visitor)) {
					map.put(visitor, 1);
					continue;
				}
				map.put(visitor, map.get(visitor) + 1);
			}
		}
	}

	private static Map<String, Integer> getUserFriendsOfFriends(String user, List<List<String>> friends,
		List<String> userFriends) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < friends.size(); i++) {
			for (int j = 0; j < userFriends.size(); j++) {
				if (!friends.get(i).contains(user) && friends.get(i).contains(userFriends.get(j))) {
					String userFriend = friends.get(i).get(0).equals(userFriends.get(j)) ? friends.get(i).get(1) :
						friends.get(i).get(0);
					if (!map.containsKey(userFriend)) {
						map.put(userFriend, 10);
						continue;
					}
					map.put(userFriend, map.get(userFriend) + 10);
				}
			}
		}
		return map;
	}

	private static List<String> getUserFriends(String user, List<List<String>> friends) {
		List<String> userFriends = new ArrayList<>();
		for (List<String> friend : friends) {
			if (friend.contains(user)) {
				String friendA = friend.get(0);
				String friendB = friend.get(1);
				userFriends.add(friendA.equals(user) ? friendB : friendA);
			}
		}
		return userFriends;
	}

}
