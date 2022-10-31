package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {

	private static final int FRIEND_OF_FRIEND_SCORE = 10;
	private static final int VISITOR_SCORE = 1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();
		return answer;
	}

	public static void getRecommendFriends(String user, List<List<String>> friends, List<String> visitors) {
		InputValidator.checkRightInput(user, friends, visitors);
		HashMap<String, List<String>> friendsRelations = getFriendsRelations(friends, user);
		HashMap<String, Integer> friendOfFriendScores = getFriendOfFriendScore(friendsRelations, user);
		HashMap<String, Integer> visitorsScore = getVisitorsScore(visitors);
		HashMap<String, Integer> totalScores = getTotalScores(visitorsScore, friendOfFriendScores);
	}

	public static HashMap<String, Integer> getTotalScores(HashMap<String, Integer> visitorScore,
		HashMap<String, Integer> friendOfFriendScore) {
		visitorScore.forEach(
			(key, value) -> friendOfFriendScore.merge(key, value, (score1, score2) -> score1 + score2));
		return friendOfFriendScore;
	}

	public static HashMap<String, Integer> getVisitorsScore(final List<String> visitors) {
		HashMap<String, Integer> visitorsScores = new HashMap<>();
		for (String visitor : visitors) {
			putVisitorsScoreMap(visitorsScores, visitor);
		}
		return visitorsScores;
	}

	private static void putVisitorsScoreMap(HashMap<String, Integer> visitorsScores, String visitor) {
		if (visitorsScores.containsKey(visitor)) {
			visitorsScores.put(visitor, visitorsScores.get(visitor) + VISITOR_SCORE);
		} else {
			visitorsScores.put(visitor, VISITOR_SCORE);
		}
	}

	public static HashMap<String, Integer> getFriendOfFriendScore(final HashMap<String, List<String>> relations,
		final String user) {
		HashMap<String, Integer> relationsScore = new HashMap<>();
		for (String friend : relations.get(user)) {
			checkFriendsOfUser(relations, relationsScore, friend);
		}
		return relationsScore;
	}

	private static void checkFriendsOfUser(HashMap<String, List<String>> relations,
		HashMap<String, Integer> relationsScore,
		String friend) {
		for (String friendOfFriend : relations.get(friend)) {
			addFriendOfFriendScore(relationsScore, friendOfFriend);
		}
	}

	private static void addFriendOfFriendScore(HashMap<String, Integer> relationsScore, final String friendOfFriend) {
		if (relationsScore.containsKey(friendOfFriend)) {
			relationsScore.put(friendOfFriend, relationsScore.get(friendOfFriend) + FRIEND_OF_FRIEND_SCORE);
		} else {
			relationsScore.put(friendOfFriend, FRIEND_OF_FRIEND_SCORE);
		}
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
