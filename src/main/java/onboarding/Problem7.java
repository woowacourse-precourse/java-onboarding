package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
}
