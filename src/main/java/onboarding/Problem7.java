package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

	private static final int FRIEND_POINT = 10;
	private static final int VISITOR_POINT = 1;
	static List<String> friendName = new ArrayList<>();
	static HashMap<String, Integer> recommendation = new HashMap<>();

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

		findFriend(user, friends);
		findFriendOfFriend(user, friends);
		findVisitor(visitors);
		List<String> answer = Collections.emptyList();
		return answer;
	}

	private static void findFriend(String user, List<List<String>> friends) {
		for (List<String> relation : friends) {
			int index = relation.indexOf(user);
			if (index > -1) {
				String friend = relation.get(1 - index);
				friendName.add(friend);
			}
		}
	}

	private static boolean isFriend(String friend) {
		return friendName.contains(friend);
	}

	private static void addPoint(String user, int score) {
		if (recommendation.containsKey(user)) {
			score += recommendation.get(user);
		}
		recommendation.put(user, score);
	}

	private static void findFriendOfFriend(String user, List<List<String>> friends) {
		for (List<String> relation : friends) {
			if (relation.contains(user)) {
				continue;
			}

			String friend1 = relation.get(0);
			String friend2 = relation.get(1);

			if (isFriend(friend1) ^ isFriend(friend2)) {
				if (isFriend(friend1)) {
					addPoint(friend2, FRIEND_POINT);
				} else {
					addPoint(friend1, FRIEND_POINT);
				}
			}
		}
	}

	private static void findVisitor(List<String> visitors) {
		for (String visitor : visitors) {
			if (!isFriend(visitor)) {
				addPoint(visitor, VISITOR_POINT);
			}
		}
	}
}
