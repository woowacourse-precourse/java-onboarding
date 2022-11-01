package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {

	private static final int FRIEND_OF_FRIEND_SCORE = 10;
	private static final int VISITOR_SCORE = 1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();
		answer = getRecommendFriends(user, friends, visitors);
		return answer;
	}

	public static List<String> getRecommendFriends(String user, List<List<String>> friends, List<String> visitors) {
		InputValidator.checkRightInput(user, friends, visitors);
		HashMap<String, List<String>> friendsRelations = getFriendsRelationsMap(friends, user);
		HashMap<String, Integer> friendOfFriendScores = getFriendOfFriendScores(friendsRelations, user);
		HashMap<String, Integer> visitorsScore = getVisitorsScores(visitors);
		HashMap<String, Integer> totalScores = getTotalScores(visitorsScore, friendOfFriendScores);

		List<String> friendsOfUser = friendsRelations.get(user);
		HashMap<String, Integer> totalScoresExcludingUserFriends = removeUsers(user, friendsOfUser, totalScores);

		List<Map.Entry<String, Integer>> sortedTotalScores = sortHashMap(totalScoresExcludingUserFriends);
		return getFiveRecommendFriends(sortedTotalScores);
	}

	public static List<String> getFiveRecommendFriends(List<Map.Entry<String, Integer>> totalScores) {
		if (totalScores.size() >= 5) {
			return totalScores.stream().map(x -> x.getKey()).limit(5).collect(Collectors.toList());
		}
		return totalScores.stream().map(x -> x.getKey()).collect(Collectors.toList());
	}

	public static List<Map.Entry<String, Integer>> sortHashMap(HashMap<String, Integer> totalScores) {
		List<Map.Entry<String, Integer>> totalScoreList = totalScores
			.entrySet()
			.stream()
			.collect(Collectors.toList());

		Collections.sort(totalScoreList, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
					return (o1.getKey().compareTo(o2.getKey()));
				}
				return o2.getValue() - o1.getValue();
			}
		});
		return totalScoreList;
	}

	public static HashMap<String, Integer> removeUsers(String user, List<String> friendsOfUser,
		HashMap<String, Integer> totalScores) {
		totalScores.remove(user);
		removeFriendsOfUser(friendsOfUser, totalScores);
		return totalScores;
	}

	private static void removeFriendsOfUser(List<String> friendsOfUser, HashMap<String, Integer> totalScores) {
		for (String friend : friendsOfUser) {
			totalScores.remove(friend);
		}
	}

	public static HashMap<String, Integer> getTotalScores(HashMap<String, Integer> visitorScore,
		HashMap<String, Integer> friendOfFriendScore) {
		visitorScore.forEach(
			(key, value) -> friendOfFriendScore.merge(key, value, (score1, score2) -> score1 + score2));
		return friendOfFriendScore;
	}

	public static HashMap<String, Integer> getVisitorsScores(final List<String> visitors) {
		HashMap<String, Integer> visitorsScores = new HashMap<>();
		for (String visitor : visitors) {
			visitorsScores.put(visitor, getVisitorsScore(visitorsScores, visitor));
		}
		return visitorsScores;
	}

	private static Integer getVisitorsScore(HashMap<String, Integer> visitorsScores, String visitor) {
		if (visitorsScores.containsKey(visitor)) {
			return visitorsScores.get(visitor) + VISITOR_SCORE;
		}
		return VISITOR_SCORE;
	}

	public static HashMap<String, Integer> getFriendOfFriendScores(final HashMap<String, List<String>> relations,
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
			relationsScore.put(friendOfFriend, getFriendOfFriendScore(relationsScore, friendOfFriend));
		}
	}

	private static Integer getFriendOfFriendScore(HashMap<String, Integer> relationsScore,
		final String friendOfFriend) {
		if (relationsScore.containsKey(friendOfFriend)) {
			return relationsScore.get(friendOfFriend) + FRIEND_OF_FRIEND_SCORE;
		}
		return FRIEND_OF_FRIEND_SCORE;
	}

	public static HashMap<String, List<String>> getFriendsRelationsMap(final List<List<String>> friends, String user) {
		HashMap<String, List<String>> relations = new HashMap<>();
		relations.put(user, new ArrayList<>(List.of()));
		for (List<String> friend : friends) {
			String friend1 = friend.get(0);
			String friend2 = friend.get(1);
			relations.put(friend1, getFriendsRelations(relations, friend1, friend2));
			relations.put(friend2, getFriendsRelations(relations, friend2, friend1));
		}
		return relations;
	}

	private static List<String> getFriendsRelations(HashMap<String, List<String>> relations, String friend1,
		String friend2) {
		if (relations.containsKey(friend1)) {
			List<String> relation = relations.get(friend1);
			relation.add(friend2);
			return relation;
		}
		return new ArrayList<>(List.of(friend2));
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
				checkLowerCase(charArray, i);
			}
		}

		private static void checkLowerCase(char[] charArray, int i) {
			if (!Character.isLowerCase(charArray[i])) {
				throw new IllegalArgumentException();
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
