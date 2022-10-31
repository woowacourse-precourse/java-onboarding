package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
	static HashMap<String, List<String>> friendList = new HashMap<>();

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();

		String mate1;
		String mate2;
		for (List<String> mate : friends) {
			mate1 = mate.get(0);
			mate2 = mate.get(1);
			makeGraph(mate1, mate2);
		}
		return answer;
	}

	public static void makeGraph(String mate1, String mate2) {
		String firstMate;
		String secondMate;
		for (int i = 0; i < 2; i++) {
			firstMate = i == 0 ? mate1 : mate2;
			secondMate = i == 0 ? mate2 : mate1;
			if (!friendList.containsKey(firstMate)) {
				friendList.put(firstMate, new ArrayList<>());
				continue;
			}
			friendList.get(firstMate).add(secondMate);
		}
	}
}
