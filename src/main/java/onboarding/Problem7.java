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
		findFriendofFriend(user, friends);
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

	private static void findFriendofFriend(String user, List<List<String>> friends) {
		for (List<String> relation : friends) {
			if (relation.contains(user)) {
				continue;
			}

			String friend1 = relation.get(0);
			String friend2 = relation.get(1);

			if (isFriend(friend1) ^ isFriend(friend2)) {
				if (isFriend(friend1)) {
					addFriendPoint(friend2);
				} else {
					addFriendPoint(friend1);
				}
			}
		}
	}

	private static void addFriendPoint(String user) {
		int score = FRIEND_POINT;
		if (recommendation.containsKey(user)) {
			score += recommendation.get(user);
		}
		recommendation.put(user, score);
	}

	private static void findVisitor(List<String> visitors) {
		for (String visitor : visitors) {
			if (!isFriend(visitor)) {
				addVisitorPoint(visitor);
			}
		}
	}

	private static void addVisitorPoint(String user) {
		int score = VISITOR_POINT;
		if (recommendation.containsKey(user)) {
			score += recommendation.get(user);
		}
		recommendation.put(user, score);
	}
}
