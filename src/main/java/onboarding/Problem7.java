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

		for (String list : visitors) {
			int count = 0;
			for (int i = 0; i < userfriends.size(); i++) {
				if (list != userfriends.get(i)) {
					count++;
				}
			}
			if (count == userfriends.size()) {
				map.put(list, map.getOrDefault(list, 0) + 1);
			}
		}

	}


}