package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {

	static List<String> friendName = new ArrayList<>();

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

		findFriend(user, friends);
		List<String> answer = Collections.emptyList();
		return answer;
	}

	private static void findFriend(String user, List<List<String>> friends) {
		for (List<String> relation : friends) {
			int index = relation.indexOf(user);
			if (index > -1) {
				String friend = relation.get(1 - index);
				friendName.add(friend);
			}
		}
	}
}
