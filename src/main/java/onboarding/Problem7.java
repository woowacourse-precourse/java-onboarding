package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		check1(user);
		check2(friends);
		check3(visitors);
		check4(user, friends);
		List<String> answer = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

		for (List<String> friend : friends) {
			String fr = friend.get(0);
			String me = friend.get(1);
			if (fr == user) {
				list.add(me);
			} else if (me == user) {
				list.add(fr);
			}
		}
		for (List<String> friendlist : friends) {
			String a = friendlist.get(0);
			String b = friendlist.get(1);
			if (list.contains(a) && !friendlist.contains(user)) {
				list1.add(b);
			} else if (list.contains(b) && !friendlist.contains(user)) {
				list1.add(a);
			}
		}

		for (int i = 0; i < list1.size(); i++) {
			map.put(list1.get(i), map.getOrDefault(list1.get(i), 0) + 10);
		}

		for (int i = 0; i < visitors.size(); i++) {
			String c = list.get(0);
			String d = list.get(1);
			if (c != (visitors.get(i)) && d != (visitors.get(i)))
				map.put(visitors.get(i), map.getOrDefault(visitors.get(i),
					0) + 1);
		}
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		for (String key : map.keySet()) {
			answer.add(key);
		}

		return answer;
	}

	public static void check1(String user) throws IllegalArgumentException {
		String pattern = "^[a-z]*$";
		if (user.length() < 1 || user.length() > 30 || !Pattern.matches(pattern, user)) {
			throw new IllegalArgumentException("user의 길이는 1이상 30이하 이여야 하고 알파벳 소문자 여야 합니다.");
		}
	}

	public static void check2(List<List<String>> friends) throws IllegalArgumentException {
		for (List<String> friend : friends) {
			String fr = friend.get(0);
			String me = friend.get(1);
			if (fr.length() < 1 || fr.length() > 30 && me.length() < 1 || me.length() > 30) {
				throw new IllegalArgumentException("아이디는 길이가 1 이상 30 이하인 문자열 이어야 합니다.");
			}
			if (fr == me) {
				throw new IllegalArgumentException("동일한 친구 관계가 중복해서 주어지면 안된다.");
			}
		}
		if (friends.size() < 1 || friends.size() > 10000) {
			throw new IllegalArgumentException("friends는 길이가 1 이상 10,000 이하인 리스트/배열 이어야 합니다.");
		}

	}

	public static void check3(List<String> visitors) throws IllegalArgumentException {
		if (visitors.size() < 1 || visitors.size() > 10000) {
			throw new IllegalArgumentException("visitors는 길이가 1 이상 10,000 이하인 리스트/배열 이어야 합니다.");
		}
	}

	public static void check4(String user, List<List<String>> friends) throws IllegalArgumentException {
		List<String> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		for (List<String> friend : friends) {
			String fr = friend.get(0);
			String me = friend.get(1);
			if (fr == user) {
				list.add(me);
			} else if (me == user) {
				list.add(fr);
			}
		}
		for (List<String> friendlist : friends) {
			String a = friendlist.get(0);
			String b = friendlist.get(1);
			if (list.contains(a) && !friendlist.contains(user)) {
				list1.add(b);
			} else if (list.contains(b) && !friendlist.contains(user)) {
				list1.add(a);
			}
		}
		if (list.isEmpty()) {
			throw new IllegalArgumentException("추천 친구가 없습니다.");
		}
	}

}
