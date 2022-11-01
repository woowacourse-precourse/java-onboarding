package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
	static final int SCORE_FRIENDS_KNOW_WITH_USER = 10;
	static final int SCORE_VISIT_USER_SNS = 1;

	static final Map<String, List<String>> friendRelationGraph = new HashMap<>();
	static final Map<String, Integer> recommendationScores = new HashMap<>();

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();
		return answer;
	}

	public static void giveScoresToFriendsKnowWithUser(String user) {
		Set<String> friendsOfUser = findFriendsOfUser(user);
		friendsOfUser.add(user);

		for (String friendOfUser : friendsOfUser) {
			Set<String> friendsKnowWithUser = findFriendsOfUser(friendOfUser);

			for (String friendKnowWithUser : friendsKnowWithUser) {
				if (!friendsOfUser.contains(friendKnowWithUser)) {
					int previousScore = recommendationScores.get(friendKnowWithUser);
					recommendationScores.put(friendKnowWithUser, previousScore + SCORE_FRIENDS_KNOW_WITH_USER);
				}
			}
		}
	}

	public static Set<String> findFriendsOfUser(String user) {
		List<String> friendsOfUser = friendRelationGraph.get(user);
		return new HashSet<>(friendsOfUser);
	}

	public static void initRecommendationScores() {
		friendRelationGraph.keySet()
				.stream()
				.forEach(key -> recommendationScores.putIfAbsent(key, 0));
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
