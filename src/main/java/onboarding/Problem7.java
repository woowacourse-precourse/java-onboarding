package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    	List<String> userfriends = new ArrayList<>();
		Map<String, Integer> friendsMap = new HashMap<>();
		List<String> answer = new ArrayList<>();
		// 사용자의 친구의 친구 찾기
		for (List<String> list : friends) {
			String friend1 = list.get(0), friend2 = list.get(1);
			if (friend1 == user) {
				userfriends.add(friend2);
			}
			if (friend2 == user) {
				userfriends.add(friend1);
			}
		}
		// 사용자의 친구의 친구라면 10점 얻기
		for (List<String> list : friends) {
			String friend1 = list.get(0), friend2 = list.get(1);
			if (userfriends.contains(friend1) && userfriends.contains(friend2)) {
				continue;
			}
			if (userfriends.contains(friend1) && friend2 != user) {
				friendsMap.put(friend2, friendsMap.getOrDefault(friend2, 0) + 10);
			}
			else if (userfriends.contains(friend2) && friend1 != user) {
				friendsMap.put(friend1, friendsMap.getOrDefault(friend1, 0) + 10);
			}
			
			for (int i = 0; i < userfriends.size(); i++) {
				if (friend2 != user && userfriends.get(i) == friend1) {
					friendsMap.put(friend2, friendsMap.getOrDefault(friend2, 0) + 10);
				} else if (friend1 != user && userfriends.get(i) == friend2) {
					friendsMap.put(friend1, friendsMap.getOrDefault(friend1, 0) + 10);
				}
			}
		}
		// 방문자라면 1점 추가
		for (String visitor : visitors) {
			if (!userfriends.contains(visitor)) {
				friendsMap.put(visitor, friendsMap.getOrDefault(visitor, 0) + 1);
			}
		}
		// 정렬
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(friendsMap.entrySet());
		entryList.sort(Comparator.comparing(Map.Entry::getKey));
		entryList.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
		for (Map.Entry<String, Integer> name : entryList) {
			if (answer.size() <= 5) {
				answer.add(name.getKey());
			}
		}
		return answer;
    }
}
