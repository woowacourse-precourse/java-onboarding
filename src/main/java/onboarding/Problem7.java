package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

	private static final int FRIEND_SCORE = 10;
	private static final int TIMELINE_SCORE = 1;

	public static Map<String, List<String>> createFriendRelations(List<List<String>> friends) {
		Map<String, List<String>> friendRelations = new HashMap<>();

		for (List<String> friend : friends) {
			createFriendRelation(friend.get(0), friend.get(1), friendRelations);
			createFriendRelation(friend.get(1), friend.get(0), friendRelations);
		}

		return friendRelations;
	}

	public static void createFriendRelation(String friend1, String friend2,
											Map<String, List<String>> friendRelations) {
		List<String> friendList;
		friendList = friendRelations.getOrDefault(friend1, new ArrayList<>());
		friendList.add(friend2);
		friendRelations.put(friend1, friendList);
	}

	public static Map<String, Integer> createFriendRecommendScore(String user, List<String> visitors,
																  Map<String, List<String>> friendRelations) {
		Map<String, Integer> friendRecommendScore = new HashMap<>();

		createFriendRecommendScoreByFriend(user, friendRelations, friendRecommendScore);
		createFriendRecommendScoreByVistors(user, friendRelations, visitors, friendRecommendScore);

		return friendRecommendScore;
	}

	public static void createFriendRecommendScoreByFriend(String user, Map<String, List<String>> friendRelations,
														  Map<String, Integer> friendRecommendScore) {
		for (String userFriends : friendRelations.get(user)) {
			for (String friendOfUserFriend : friendRelations.get(userFriends)) {
				if (friendOfUserFriend.equals(user)) {
					continue;
				}
				if (!friendRelations.get(user).contains(friendOfUserFriend)) {
					friendRecommendScore.put(friendOfUserFriend, friendRecommendScore.getOrDefault(friendOfUserFriend,
						0) + FRIEND_SCORE);
				}
			}
		}
	}

	public static void createFriendRecommendScoreByVistors(String user, Map<String, List<String>> friendRelations,
														   List<String> visitors,
														   Map<String, Integer> friendRecommendScore) {
		for (String visitor : visitors) {
			if (!friendRelations.get(user).contains(visitor)) {
				friendRecommendScore.put(visitor, friendRecommendScore.getOrDefault(visitor, 0) + TIMELINE_SCORE);
			}
		}
	}

	public static List<String> createFriendRecommendResult(Map<String, Integer> friendRecommendScore) {
		List<String> answer;

		answer = friendRecommendScore.entrySet().stream()
			.filter(s -> s.getValue() > 0)
			.sorted(Collections.reverseOrder(Map.Entry.<String, Integer>comparingByValue())
				.thenComparing(Map.Entry.<String, Integer>comparingByKey()))
			.limit(5)
			.map(s -> s.getKey())
			.collect(Collectors.toList());

		return answer;
	}

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		// List<String> answer = Collections.emptyList();
		List<String> answer;
		Map<String, List<String>> friendRelations;
		Map<String, Integer> friendRecommendScore;

		friendRelations = createFriendRelations(friends);
		friendRecommendScore = createFriendRecommendScore(user, visitors, friendRelations);

		answer = createFriendRecommendResult(friendRecommendScore);

        return answer;
    }
}
