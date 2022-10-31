package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		HashMap<String, ArrayList<String>> friendshipChart = new HashMap<>();

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

		Map<String, Boolean> memberUpdated = new HashMap<>();
		for (String member : friendshipChart.keySet()) {
			memberUpdated.put(member, false);
		}

		List<Set<String>> groupCollection = new ArrayList<>();
		for (String member : friendshipChart.keySet()) {
			if (!memberUpdated.get(member)) {
				Set<String> connectedMembers = new HashSet<>();
				setConnectedMembers(member, friendshipChart, memberUpdated, connectedMembers);
				groupCollection.add(connectedMembers);
			}
		}

		Set<String> recommendedFriends = new HashSet<>();
		for (Set<String> group : groupCollection) {
			if (group.contains(user)) {
				recommendedFriends = group;
				break;
			}
		}
		recommendedFriends.remove(user);
		recommendedFriends.addAll(visitors);

		for (String friend : friendshipChart.get(user)) {
			recommendedFriends.remove(friend);
		}

		HashMap<String, Integer> scoreOfRecommendation = new HashMap<>();
		for (String member : recommendedFriends) {
			scoreOfRecommendation.put(member, 0);
		}

		for (String friend : friendshipChart.get(user)) {
			for (String friendOfFriend : friendshipChart.get(friend)) {
				if (scoreOfRecommendation.containsKey(friendOfFriend)) {
					scoreOfRecommendation.put(friendOfFriend, scoreOfRecommendation.get(friendOfFriend) + 10);
				}
			}
		}

		for (String visitor : visitors) {
			if (scoreOfRecommendation.containsKey(visitor)) {
				scoreOfRecommendation.put(visitor, scoreOfRecommendation.get(visitor) + 1);
			}
		}

		scoreOfRecommendation.entrySet().removeIf(entry -> entry.getValue() == 0);

		List<String> sortedRecommendation = new ArrayList<>(scoreOfRecommendation.keySet());
		sortedRecommendation.sort((a, b) -> {
			if (scoreOfRecommendation.get(a).equals(scoreOfRecommendation.get(b))) {
				return a.compareTo(b);
			}
			return scoreOfRecommendation.get(b) - scoreOfRecommendation.get(a);
		});

		return sortedRecommendation;
	}

	private static void setConnectedMembers(String member, HashMap<String, ArrayList<String>> friendshipChart,
		Map<String, Boolean> memberUpdated, Set<String> connectedMembers) {
		memberUpdated.put(member, true);
		connectedMembers.add(member);
		for (String otherMember : friendshipChart.get(member)) {
			if (!memberUpdated.get(otherMember)) {
				setConnectedMembers(otherMember, friendshipChart, memberUpdated, connectedMembers);
			}
		}
	}
}
