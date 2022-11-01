package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {

	public static final int POINT_FRIEND_OF_FRIEND = 10;
	public static final int POINT_VISITOR = 1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		HashMap<String, ArrayList<String>> friendshipChart = new HashMap<>();

		inputFriendshipChart(friends, friendshipChart);

		Map<String, Boolean> memberUpdated = initMemberAccess(friendshipChart);

		List<Set<String>> groupCollection = createGroupCollection(friendshipChart, memberUpdated);

		Set<String> recommendedFriends = getRecommendedFriends(user, groupCollection);
		recommendedFriends.remove(user);
		recommendedFriends.addAll(visitors);
		deleteFriend(user, friendshipChart, recommendedFriends);

		HashMap<String, Integer> scoreOfRecommendation = initRecommendationScore(recommendedFriends);
		addPointToFriendOfFriend(user, friendshipChart, scoreOfRecommendation);
		addPointToVisitors(visitors, scoreOfRecommendation);
		deleteZeroPoint(scoreOfRecommendation);

		List<String> sortedRecommendation = sortRecommendation(scoreOfRecommendation);
		sortedRecommendation = getFiveRecommendations(sortedRecommendation);

		return sortedRecommendation;
	}

	private static void inputFriendshipChart(List<List<String>> friends, HashMap<String, ArrayList<String>> friendshipChart) {
		for (List<String> friend : friends) {
			String member = friend.get(0);
			String friendOfMember = friend.get(1);

			if (!friendshipChart.containsKey(member)) {
				friendshipChart.put(member, new ArrayList<>());
			}
			if (!friendshipChart.containsKey(friendOfMember)) {
				friendshipChart.put(friendOfMember, new ArrayList<>());
			}
			friendshipChart.get(member).add(friendOfMember);
			friendshipChart.get(friendOfMember).add(member);
		}
	}

	private static Map<String, Boolean> initMemberAccess(HashMap<String, ArrayList<String>> friendshipChart) {
		Map<String, Boolean> memberUpdated = new HashMap<>();
		for (String member : friendshipChart.keySet()) {
			memberUpdated.put(member, false);
		}
		return memberUpdated;
	}

	private static List<Set<String>> createGroupCollection(HashMap<String, ArrayList<String>> friendshipChart,
		Map<String, Boolean> memberUpdated) {
		List<Set<String>> groupCollection = new ArrayList<>();
		for (String member : friendshipChart.keySet()) {
			if (!memberUpdated.get(member)) {
				Set<String> connectedMembers = new HashSet<>();
				setConnectedMembers(member, friendshipChart, memberUpdated, connectedMembers);
				groupCollection.add(connectedMembers);
			}
		}
		return groupCollection;
	}

	private static void setConnectedMembers(String member, HashMap<String, ArrayList<String>> friendshipChart,
		Map<String, Boolean> memberUpdated, Set<String> connectedMembers) {
		memberUpdated.put(member, true);
		connectedMembers.add(member);
		for (String friendOfMember : friendshipChart.get(member)) {
			if (!memberUpdated.get(friendOfMember)) {
				setConnectedMembers(friendOfMember, friendshipChart, memberUpdated, connectedMembers);
			}
		}
	}

	private static Set<String> getRecommendedFriends(String user, List<Set<String>> groupCollection) {
		Set<String> recommendedFriends = new HashSet<>();
		for (Set<String> group : groupCollection) {
			if (group.contains(user)) {
				recommendedFriends = group;
				break;
			}
		}
		return recommendedFriends;
	}

	private static void deleteFriend(String user, HashMap<String, ArrayList<String>> friendshipChart,
		Set<String> recommendedFriends) {
		for (String friend : friendshipChart.get(user)) {
			recommendedFriends.remove(friend);
		}
	}


	private static HashMap<String, Integer> initRecommendationScore(Set<String> recommendedFriends) {
		HashMap<String, Integer> scoreOfRecommendation = new HashMap<>();
		for (String member : recommendedFriends) {
			scoreOfRecommendation.put(member, 0);
		}
		return scoreOfRecommendation;
	}

	private static void addPointToFriendOfFriend(String user, HashMap<String, ArrayList<String>> friendshipChart,
		HashMap<String, Integer> scoreOfRecommendation) {
		for (String friend : friendshipChart.get(user)) {
			for (String friendOfFriend : friendshipChart.get(friend)) {
				if (scoreOfRecommendation.containsKey(friendOfFriend)) {
					scoreOfRecommendation.put(friendOfFriend, scoreOfRecommendation.get(friendOfFriend) + POINT_FRIEND_OF_FRIEND);
				}
			}
		}
	}

	private static void addPointToVisitors(List<String> visitors, HashMap<String, Integer> scoreOfRecommendation) {
		for (String visitor : visitors) {
			if (scoreOfRecommendation.containsKey(visitor)) {
				scoreOfRecommendation.put(visitor, scoreOfRecommendation.get(visitor) + POINT_VISITOR);
			}
		}
	}

	private static void deleteZeroPoint(HashMap<String, Integer> scoreOfRecommendation) {
		scoreOfRecommendation.entrySet().removeIf(entry -> entry.getValue() == 0);
	}


	private static List<String> sortRecommendation(HashMap<String, Integer> scoreOfRecommendation) {
		List<String> sortedRecommendation = new ArrayList<>(scoreOfRecommendation.keySet());
		sortedRecommendation.sort((a, b) -> {
			if (scoreOfRecommendation.get(a).equals(scoreOfRecommendation.get(b))) {
				return a.compareTo(b);
			}
			return scoreOfRecommendation.get(b) - scoreOfRecommendation.get(a);
		});
		return sortedRecommendation;
	}

	private static List<String> getFiveRecommendations(List<String> recommendations) {
		if (recommendations.size() > 5) {
			recommendations = recommendations.subList(0, 5);
		}
		return recommendations;
	}

}
