package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		HashMap<String, List<String>> relation = makeFriendsRelation(user, friends, visitors);

		List<String> userFriends = relation.get(user);
		relation.remove(user);

		getAcquaintanceScore(relation, userFriends);
		getVisitorScore(relation, visitors);

		List<String> result = processData(relation, userFriends);
		return result;
    }

	private static HashMap makeFriendsRelation(String user, List<List<String>> data, List<String> visitors) {
		HashMap<String, List<String>> temp = new HashMap<>();
		temp.put(user, new ArrayList<>());

		for (List info : data) {
			for (Object person : info) {
				if (!temp.containsKey((String)person)) {
					ArrayList<String> defaultScore = new ArrayList<>();
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
					ArrayList<String> defaultScore = new ArrayList<>();
					defaultScore.add("0");
					temp.put(visitor, defaultScore);
				}
			}
		}
		return temp;
	}

	private static void getAcquaintanceScore(HashMap<String, List<String>> relation, List<String> userFriends) {
		for (String name : userFriends) {
			for (String person : relation.keySet()) {
				if (relation.get(person).contains(name)) {
					relation.get(person).set(0, String.valueOf(Integer.parseInt(relation.get(person).get(0)) + 10));
				}
			}
		}
	}

	private static void getVisitorScore(HashMap<String, List<String>> relation, List<String> visitors) {
		for (String visitor : visitors) {
			relation.get(visitor).set(0, String.valueOf(Integer.parseInt(relation.get(visitor).get(0)) + 1));
		}
	}

	private static List<String> processData(HashMap<String, List<String>> relation, List<String> userFriends) {
		Map<String, Integer> data = new HashMap<>();
		for (String person : relation.keySet()) {
			data.put(person, Integer.parseInt(relation.get(person).get(0)));
		}

		// user와 이미 친구인 관계는 목록에서 제거
		for (String name : userFriends) {
			if (data.containsKey(name)) {
				data.remove(name);
			}
		}

		//점수가 0인 값 전부 삭제
		data.entrySet().removeIf(
				entry -> entry.getValue().equals(0));

		//점수가 큰 순으로 정렬, 점수가 같다면 사전순으로 정렬
		List<Map.Entry<String, Integer>> list = new ArrayList<>(data.entrySet());
		Collections.sort(list, (first, second) -> {
			if (first.getValue() > second.getValue()) {
				return -1;
			} else if (first.getValue() < second.getValue()) {
				return 1;
			}
			return first.getKey().compareTo(second.getKey());
		});

		//추천 리스트 추출
		List<String> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (i == 5)
				break;
			else {
				result.add(list.get(i).getKey());
			}
		}
		return result;
	}
}
