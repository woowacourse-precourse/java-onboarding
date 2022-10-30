package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

	private static HashMap makeFriendsList(String user, List<List<String>> data, List<String> visitors) {
		HashMap<String, List<String>> temp = new HashMap<>();
		temp.put(user, new ArrayList<>());

		for (List info : data) {
			for (Object person : info) {
				if (!temp.containsKey((String)person)) {
					ArrayList<String> one = new ArrayList<>();
					one.add("0");
					temp.put((String)person, one);
				}
			}

			//앞 사람 확인
			if (temp.containsKey(info.get(0))) {
				List<String> trash = temp.get(info.get(0));
				trash.add((String)info.get(1));
			}

			//뒷 사람 확인
			if (temp.containsKey(info.get(1))) {
				List<String> trash = temp.get(info.get(1));
				trash.add((String)info.get(0));
			}

			for (String visitor : visitors) {
				if (!temp.containsKey(visitor)) {
					ArrayList<String> one = new ArrayList<>();
					one.add("0");
					temp.put(visitor, one);
				}
			}
		}
		return temp;
	}

	private static void getKnowScore(HashMap<String, List<String>> relation, List<String> userFriends) {
		for (String name : userFriends) {
			for (String first : relation.keySet()) {
				if (relation.get(first).contains(name)) {
					relation.get(first).set(0, String.valueOf(Integer.parseInt(relation.get(first).get(0)) + 10));
				}
			}
		}
	}

	private static void getVisitScore(HashMap<String, List<String>> relation, List<String> visitors) {
		for (String visitor : visitors) {
			relation.get(visitor).set(0, String.valueOf(Integer.parseInt(relation.get(visitor).get(0)) + 1));
		}
	}

	private static List<String> processData(HashMap<String, List<String>> relation, List<String> userFriends) {
		Map<String, Integer> data = new HashMap<>();
		for (String a : relation.keySet()) {
			data.put(a, Integer.parseInt(relation.get(a).get(0)));
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
