package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {

	private static HashMap<String, Integer> pointList;
	private static HashMap<String, List<String>> friendsList;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

		pointList = new HashMap<>();
		friendsList = new HashMap<>();

		initial(friends);

		if (friendsList.containsKey(user)) {
			List<String> userFriendsList = friendsList.get(user);
			for (String name : userFriendsList) {
				addPoint(name, user);
			}
		}

		for (String visitor : visitors) {
			if (!visitor.equals(user) && !friendsList.get(user).contains(visitor)) {
				addPoint1(visitor);
			}
		}

		LinkedList<Map.Entry<String, Integer>> resultList = new LinkedList<>(pointList.entrySet());
		resultList.sort((o1, o2) -> {
			if (o1.getValue().equals(o2.getValue())) {
				return o1.getKey().compareTo(o2.getKey());
			} else {
				return Integer.compare(o2.getValue(), o1.getValue());
			}
		});

		List<String> answer = new ArrayList<>();
		for (int i = 0; i < Math.min(5, resultList.size()); i++) {
			answer.add(resultList.get(i).getKey());
		}
		return answer;
	}

	private static void addPoint(String name, String user) {
		List<String> hisFriendList = friendsList.get(name);
		for (String friendName : hisFriendList) {
			if (!friendsList.get(user).contains(friendName) && !friendName.equals(user)) {
				addPoint10(friendName);
			}
		}

	}

	private static void addPoint1(String friendName) {
		if (pointList.containsKey(friendName)) {
			pointList.replace(friendName, pointList.get(friendName) + 1);
		} else {
			pointList.put(friendName, 1);
		}
	}

	private static void addPoint10(String friendName) {
		if (pointList.containsKey(friendName)) {
			pointList.replace(friendName, pointList.get(friendName) + 10);
		} else {
			pointList.put(friendName, 10);
		}
	}

	private static void initial(List<List<String>> friends) {
		for (List<String> friend : friends) {
			String friendA = friend.get(0);
			String friendB = friend.get(1);
			addToFriendsList(friendsList, friendA, friendB);
			addToFriendsList(friendsList, friendB, friendA);
		}
	}

	private static void addToFriendsList(HashMap<String, List<String>> friendsList, String friendA, String friendB) {
		if (friendsList.containsKey(friendA)) {
			friendsList.get(friendA).add(friendB);
		} else {
			List<String> tempList = new ArrayList<>();
			tempList.add(friendB);
			friendsList.put(friendA, tempList);
		}
	}
}
