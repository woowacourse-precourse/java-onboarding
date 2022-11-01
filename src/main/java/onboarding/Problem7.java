package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
	public static final int defaultValue = 0;
	public static final int friendOfFriendScore = 10;
	public static final int visitedScore = 1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, List<String>> friendList = new HashMap<>();
		for (List<String> f : friends) {
			friendList.computeIfAbsent(f.get(0), s -> new ArrayList<>()).add(f.get(1));
			friendList.computeIfAbsent(f.get(1), s -> new ArrayList<>()).add(f.get(0));
		}

		Map<String, Integer> score = new HashMap<>();
		List<String> friendOfUSeer = friendList.get(user);

		for (String name : friendOfUSeer) {
			for (String name2 : friendList.get(name)) {
				if (name2.equals(user)) {
					continue;
				}
				score.put(name2, score.getOrDefault(name2, defaultValue) + friendOfFriendScore);
			}
		}

		for (String v : visitors) {
			if (friendList.get(user).contains(v)) {
				continue;
			}
			score.put(v, score.getOrDefault(v, defaultValue) + visitedScore);
		}

		List<String> answer = new ArrayList<>(score.keySet());
		Collections.sort(answer);
		Collections.sort(answer, (o1, o2) -> (score.get(o2).compareTo(score.get(o1))));

		answer = sliceAnswerSize(answer);
		return answer;
	}

	private static List<String> sliceAnswerSize(List<String> answer) {
		if (answer.size() > 5) {
			answer = answer.subList(0, 5);
		}
		return answer;
	}

}
