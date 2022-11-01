package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		checkList(user, friends, visitors);
		List<String> userfriends = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		List<String> answer = new ArrayList<>();
		for (List<String> list : friends) {
			String friend1 = list.get(0), friend2 = list.get(1);
			if (friend1 == user) {
				userfriends.add(friend2);
			}
			if (friend2 == user) {
				userfriends.add(friend1);
			}
		}
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

	public static void checkList(String user, List<List<String>> friends, List<String> visitors) {
		if (user.length() < 1 || user.length() > 30) {
			throw new IllegalArgumentException("아이디 길이가 부합하지 않습니다.");
		}
		if (!user.matches("^[a-z]*$")) {
			throw new IllegalArgumentException("아이디가 알파벳 소문자로 이뤄지지 않았습니다.");
		}
		if (friends.size() < 1 || friends.size() > 10000) {
			throw new IllegalArgumentException("friends는 길이가 부합하지 않습니다.");
		}
		for (List<String> list : friends) {
			String a = list.get(0), b = list.get(1);
			if (list.size() != 2) {
				throw new IllegalArgumentException("friends의 길이가 부합하지 않습니다.");
			}
			if (a.length() < 1 || a.length() > 30 && b.length() < 1 || b.length() > 30) {
				throw new IllegalArgumentException("아이디 길이가 부합하지 않습니다.");
			}
			if (!a.matches("^[a-z]*$") && !b.matches("^[a-z]*$")) {
				throw new IllegalArgumentException("아이디가 알파벳 소문자로 이뤄지지 않았습니다.");
			}
			if (a == b) {
				throw new IllegalArgumentException("동일한 친구 관계입니다.");
			}
		}
		if (visitors.size() < 1 || visitors.size() > 10000) {
			throw new IllegalArgumentException("visitors는 길이의 부합하지 않습니다.");
		}
		for (String list : visitors) {
			if (list.length() < 1 || list.length() > 30) {
				throw new IllegalArgumentException("아이디 길이가 부합하지 않습니다.");
			}
			if (!list.matches("^[a-z]*$")) {
				throw new IllegalArgumentException("아이디가 알파벳 소문자로 이뤄지지 않았습니다.");
			}
		}
	}
}