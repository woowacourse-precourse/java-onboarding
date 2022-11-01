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

		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		for (String name : map.keySet()) {
			if (answer.size() <= 5) {
				answer.add(name);
			}
		}
		return answer;
	}


}