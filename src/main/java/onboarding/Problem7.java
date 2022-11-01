package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

		List<String> userfriends = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		List<String> answer = new ArrayList<>();

		for (List<String> list : friends) {
			String friend1 = list.get(0), friend2 = list.get(1);
			for (int i = 0; i < userfriends.size(); i++) {
				if (friend2 != user && userfriends.get(i) == friend1) {
					map.put(friend2, map.getOrDefault(friend2, 0) + 10);
				} else if (friend1 != user && userfriends.get(i) == friend2) {
					map.put(friend1, map.getOrDefault(friend1, 0) + 10);
				}
			}
		}

	}


}