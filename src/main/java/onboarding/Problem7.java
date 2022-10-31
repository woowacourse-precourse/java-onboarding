package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();
		return answer;
	}

	public static void getRecommendFriends(String user, List<List<String>> friends, List<String> visitors) {
		InputValidator.checkRightInput(user, friends, visitors);
		HashMap<String, List<String>> friendsRelations = getFriendsRelations(friends, user);
	}

	public static HashMap<String, List<String>> getFriendsRelations(final List<List<String>> friends, String user) {
		HashMap<String, List<String>> relations = new HashMap<>();
		relations.put(user, new ArrayList<>(List.of()));
		for (List<String> friend : friends) {
			String friend1 = friend.get(0);
			String friend2 = friend.get(1);
			putFriendsRelationsMap(relations, friend1, friend2);
			putFriendsRelationsMap(relations, friend2, friend1);
		}
		return relations;
	}

	private static void putFriendsRelationsMap(HashMap<String, List<String>> relations, String friend1,
		String friend2) {
		if (relations.containsKey(friend1)) {
			List<String> relation = relations.get(friend1);
			relation.add(friend2);
			relations.put(friend1, relation);
		} else {
			relations.put(friend1, new ArrayList<>(List.of(friend2)));
		}
	}

	static class InputValidator {

		public static void checkRightInput(String user, List<List<String>> friends, List<String> visitors) {
			isRightUserInput(user);
			isRightFriendsInput(friends);
			isVisitorsInput(visitors);
		}

		public static boolean isRightUserInput(String user) {
			checkRightUserRange(user);
			checkUserLowerCase(user);
			return true;
		}

		public static void checkRightUserRange(String user) {
			if (user.length() < 1 || user.length() > 30) {
				throw new IllegalArgumentException();
			}
		}

		public static void checkUserLowerCase(String user) {
			char[] charArray = user.toCharArray();

			for (int i = 0; i < charArray.length; i++) {
				if (!Character.isLowerCase(charArray[i])) {
					throw new IllegalArgumentException();
				}
			}
		}

		public static boolean isRightFriendsInput(List<List<String>> friends) {
			checkRightFriendsRange(friends);
			for (List<String> friend : friends) {
				checkRightFriendUsers(friend);
			}
			return true;
		}

		public static void checkRightFriendsRange(List<List<String>> friends) {
			if (friends.size() < 1 || friends.size() > 10000) {
				throw new IllegalArgumentException();
			}
		}

		public static void checkRightFriendUsers(List<String> friend) {
			checkRightFriendRange(friend);
			for (String user : friend) {
				isRightUserInput(user);
			}
		}

		public static void checkRightFriendRange(List<String> friend) {
			if (friend.size() != 2) {
				throw new IllegalArgumentException();
			}
		}

		public static boolean isVisitorsInput(List<String> visitors) {
			checkVisitorsRange(visitors);
			for (String user : visitors) {
				isRightUserInput(user);
			}
			return true;
		}

		public static void checkVisitorsRange(List<String> visitors) {
			if (visitors.size() < 0 || visitors.size() > 10000) {
				throw new IllegalArgumentException();
			}
		}
	}
}
