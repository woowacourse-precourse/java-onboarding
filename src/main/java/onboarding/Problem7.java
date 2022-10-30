package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

	private static HashMap<String, List<String>> createFriendMap(List<List<String>> friends) {
		HashMap<String, List<String>> friendMap = new HashMap<>();

		for(List<String> friend: friends) {
			for(int i = 0;i < 2;i++) {
				if(!friendMap.containsKey(friend.get(i))) {
					ArrayList<String> list = new ArrayList<>();
					list.add(friend.get((i + 1) % 2));
					friendMap.put(friend.get(i),list);
				}
				else
					friendMap.get(friend.get(i)).add(friend.get((i + 1) % 2));
			}
		}

		return friendMap;
	}
}
