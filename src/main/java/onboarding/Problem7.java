package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Map<String, List<String>> relation = makeFriendsRelation(user, friends, visitors);

		List<String> userFriends = relation.get(user);
		relation.remove(user);

		getAcquaintanceScore(relation, userFriends);
		getVisitorScore(relation, visitors);

		List<String> result = processData(relation, userFriends);
		return result;
	}

	private static Map makeFriendsRelation(String user, List<List<String>> data, List<String> visitors) {
		Map<String, List<String>> temp = new HashMap<>();
		temp.put(user, new ArrayList<>());

		for (List info : data) {
			for (Object person : info) {
				if (!temp.containsKey((String)person)) {
					List<String> defaultScore = new ArrayList<>();
					defaultScore.add("0");
					temp.put((String)person, defaultScore);
				}
			}

			//앞 사람 확인
			if (temp.containsKey(info.get(0))) {
				List<String> friendsList = temp.get(info.get(0));
				friendsList.add((String)info.get(1));
			}

			//뒷 사람 확인
			if (temp.containsKey(info.get(1))) {
				List<String> friendsList = temp.get(info.get(1));
				friendsList.add((String)info.get(0));
			}

			for (String visitor : visitors) {
				if (!temp.containsKey(visitor)) {
					List<String> defaultScore = new ArrayList<>();
					defaultScore.add("0");
					temp.put(visitor, defaultScore);
				}
			}
		}
		return temp;
	}

	private static void getAcquaintanceScore(Map<String, List<String>> relation, List<String> userFriends) {
		for (String name : userFriends) {
			for (String person : relation.keySet()) {
				if (relation.get(person).contains(name)) {
					relation.get(person).set(0, String.valueOf(Integer.parseInt(relation.get(person).get(0)) + 10));
				}
			}
		}
	}

	private static void getVisitorScore(Map<String, List<String>> relation, List<String> visitors) {
		for (String visitor : visitors) {
			relation.get(visitor).set(0, String.valueOf(Integer.parseInt(relation.get(visitor).get(0)) + 1));
		}
	}

	private static List<String> processData(Map<String, List<String>> relation, List<String> userFriends) {
		Map<String, Integer> data = new HashMap<>();
		for (String person : relation.keySet()) {
			data.put(person, Integer.parseInt(relation.get(person).get(0)));
		}

		removeAlreadyFriends(data, userFriends);
		removeZeroScore(data);

		//점수가 큰 순으로 정렬, 점수가 같다면 사전순으로 정렬
		List<Map.Entry<String, Integer>> list = new ArrayList<>(data.entrySet());
		Collections.sort(list, (first, second) -> {
			if (first.getValue() > second.getValue()) {
				return -1;
			}
			if (first.getValue() < second.getValue()) {
				return 1;
			}
			return first.getKey().compareTo(second.getKey());
		});

		//추천 리스트 추출
		List<String> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (i == 5)
				break;
			result.add(list.get(i).getKey());
		}
		return result;
	}

	private static void removeAlreadyFriends(Map<String, Integer> user, List<String> userFriends) {
		for (String name : userFriends) {
			if (user.containsKey(name)) {
				user.remove(name);
			}
		}
	}

	private static void removeZeroScore(Map<String, Integer> scoreInfo){
		scoreInfo.entrySet().removeIf(
				entry -> entry.getValue().equals(0));
	}
}
