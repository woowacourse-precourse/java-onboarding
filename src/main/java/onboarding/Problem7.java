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
		for (String member : friendshipChart.keySet()) {
			Set<String> connectedMember = null;
			if (!memberUpdated.get(member)) {
				connectedMember = new HashSet<>();
				memberUpdated.put(member, true);
				connectedMember.add(member);
			}
		}

		List<String> answer = Collections.emptyList();
		return answer;
	}
}
