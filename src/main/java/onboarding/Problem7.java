package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
	static final int SCORE_FRIENDS_KNOW_WITH_USER = 10;
	static final int SCORE_VISIT_USER_TIMELINE = 1;
	static final int DEFAULT_SCORE = 0;

	static final Map<String, List<String>> friendRelationGraph = new HashMap<>();
	static final Map<String, Integer> recommendationScores = new HashMap<>();
	static Set<String> directFriendsOfUserSet = new HashSet<>();

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		makeFriendRelationGraph(friends);
		makeRecommendationScores(user, visitors);
		getDirectFriendsOfUser(user);

		return recommendationScores.entrySet()
				.stream()
				.filter(Problem7::isRecommendable)
				.sorted((o1, o2) -> isSameScore(o1, o2) ? compareNames(o1, o2) : compareScores(o1, o2))
				.map(Map.Entry::getKey)
				.limit(5)
				.collect(Collectors.toList());
	}

	private static void makeRecommendationScores(String user, List<String> visitors) {
		giveScoresToFriendsKnowWithUser(user);
		giveScoresToFriendsWhoVisitUserTimeline(visitors);
		recommendationScores.remove(user);
	}

	private static int compareScores(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
		return o2.getValue().compareTo(o1.getValue());
	}

	private static int compareNames(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
		return o1.getKey().compareTo(o2.getKey());
	}

	private static boolean isSameScore(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
		return compareScores(o2, o1) == 0;
	}

	private static boolean isRecommendable(Map.Entry<String, Integer> entry) {
		return !directFriendsOfUserSet.contains(entry.getKey()) && entry.getValue() > DEFAULT_SCORE;
	}

	public static void getDirectFriendsOfUser(String user) {
		List<String> directFriendsOfUserList = friendRelationGraph.get(user);
		directFriendsOfUserSet = new HashSet<>(directFriendsOfUserList);
	}

	public static void giveScoresToFriendsWhoVisitUserTimeline(List<String> visitors) {
		for (String visitor : visitors) {
			int score = recommendationScores.getOrDefault(visitor, DEFAULT_SCORE);
			recommendationScores.put(visitor, score + SCORE_VISIT_USER_TIMELINE);
		}
	}

	public static void giveScoresToFriendsKnowWithUser(String user) {
		Set<String> friendsOfUser = findFriendsOfUser(user);

		for (String friendOfUser : friendsOfUser) {
			Set<String> friendsKnowWithUser = findFriendsOfUser(friendOfUser);

			for (String friendKnowWithUser : friendsKnowWithUser) {
				int score = recommendationScores.getOrDefault(friendKnowWithUser, DEFAULT_SCORE);
				recommendationScores.put(friendKnowWithUser, score + SCORE_FRIENDS_KNOW_WITH_USER);
			}
		}
	}

	public static Set<String> findFriendsOfUser(String user) {
		List<String> friendsOfUser = friendRelationGraph.get(user);
		return new HashSet<>(friendsOfUser);
	}

	public static void makeFriendRelationGraph(List<List<String>> friends) {
		for (List<String> friend : friends) {
			addFriendRelationGraph(friend);
		}
	}

	private static void addFriendRelationGraph(List<String> friend) {
		String friendFrom = friend.get(0);
		String friendTo = friend.get(1);
		friendRelationGraph.putIfAbsent(friendFrom, new ArrayList<>());
		friendRelationGraph.putIfAbsent(friendTo, new ArrayList<>());
		friendRelationGraph.getOrDefault(friendFrom, new ArrayList<>())
				.add(friendTo);
		friendRelationGraph.getOrDefault(friendTo, new ArrayList<>())
				.add(friendFrom);
	}
}
