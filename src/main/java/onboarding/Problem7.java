package onboarding;

import java.util.ArrayList;
import java.util.Collections;
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

		Set<String> reconmmendedFriends = new HashSet<>();
		for (Set<String> group : groupCollection) {
			if (group.contains(user)) {
				reconmmendedFriends = group;
				break;
			}
		}
		reconmmendedFriends.remove(user);
		reconmmendedFriends.addAll(visitors);

		for (String friend : friendshipChart.get(user)) {
			reconmmendedFriends.remove(friend);
		}

		System.out.println(reconmmendedFriends);

		List<String> answer = Collections.emptyList();
		return answer;
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
