package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
	private static Map<String, Set<String>> mapByFriendMapSet(List<List<String>> friends) {
		Map<String, Set<String>> friendMapSet = new HashMap<>();

		for (List<String> friend : friends) {
			String friendA = friend.get(0);
			String friendB = friend.get(1);

			friendMapSet.putIfAbsent(friendA, new HashSet<>());
			friendMapSet.get(friendA).add(friendB);

			friendMapSet.putIfAbsent(friendB, new HashSet<>());
			friendMapSet.get(friendB).add(friendA);
		}
		return friendMapSet;
	}

}
