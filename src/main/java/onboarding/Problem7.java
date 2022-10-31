package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		// 중복 없는 전체 유저 리스트 생성
		List<String> userList = makeUserList(friends, visitors);

		// 유저 친구 관계 리스트 생성
		List<String> userFriendsList = makeFriendList(friends, user);

		// 유저 친구의 친구 관계 리스트 생성
		List<List<String>> userFriendsFriendsList = makeFriendFriendList(user, friends, userFriendsList);

		// 전체 유저 리스트에서 유저와 친구를 뺀 리스트 생성
		userList.remove(user);
		List<String> noFriendList = makeNoFriendList(userList, userFriendsList);

		// 친구 추천 점수 집계용 hashmap 생성
		HashMap<String, Integer> friendshipScore = new HashMap<>();

		// noFriendList의 유저들에게 점수 부여
		for (String person : noFriendList) {
			//hashmap 초기화
			friendshipScore.put(person, 0);
			// 친구의 친구 추천 점수 부여
			addFriendFriendScore(userFriendsFriendsList, friendshipScore, person);
			// 방문객 추천 점수 부여
			addVisitorScore(visitors, friendshipScore, person);
		}

		// 친구 추천 점수가 0일 경우 hashmap에서 제거
		friendshipScore.values().removeAll(Collections.singleton(0));

		// 친구 추천 리스트(answer) 만들기
		List<String> answer = new ArrayList<>();
		while (!friendshipScore.isEmpty()) {
			//가장 높은 점수인 유저들 리스트 생성
			List<String> maxValueKeys = findMaxValueKeys(friendshipScore);
			// 추천 점수가 같은 경우 이름순으로 정렬
			Collections.sort(maxValueKeys);
			// answer 리스트에 add
			answer.addAll(maxValueKeys);
			//answer 리스트에 추가된 유저들 hashmap에서 삭제
			removeHighScoreUser(friendshipScore, maxValueKeys);
		}

		// answer 리스트의 길이가 5 초과 인 경우 리스트 자르기
		return answer.size() > 5 ? answer.subList(0, 5) : answer;
	}

	private static void removeHighScoreUser(HashMap<String, Integer> friendshipScore, List<String> maxValueKeys) {
		if (maxValueKeys.size() > 0) {
			maxValueKeys.forEach(friendshipScore.keySet()::remove);
		}
	}

	private static void addVisitorScore(List<String> visitors, HashMap<String, Integer> friendshipScore,
		String person) {
		for (String visitor : visitors) {
			if (visitor.equals(person)) {
				friendshipScore.put(person, friendshipScore.get(person) + 1);
			}
		}
	}

	private static void addFriendFriendScore(List<List<String>> userFriendsFriendsList,
		HashMap<String, Integer> friendshipScore, String person) {
		for (List<String> friendList : userFriendsFriendsList) {
			if (friendList.contains(person)) {
				friendshipScore.put(person, friendshipScore.get(person) + 10);
			}
		}
	}

	private static List<String> findMaxValueKeys(HashMap<String, Integer> friendshipScore) {
		int maxValue = Collections.max(friendshipScore.values());
		List<String> maxValueKeys = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : friendshipScore.entrySet()) {
			if (entry.getValue() == maxValue) {
				String key = entry.getKey();
				maxValueKeys.add(key);
			}
		}

		return maxValueKeys;
	}

	private static List<String> makeUserList(List<List<String>> friends, List<String> visitors) {
		List<String> userList = new ArrayList<>();
		for (List<String> friend : friends) {
			userList.addAll(friend);
		}
		userList.addAll(visitors);
		return Problem6.removeListDuplication(userList);
	}

	private static List<String> makeFriendList(List<List<String>> friends, String user) {
		List<String> friendList = new ArrayList<>();
		for (List<String> friend : friends) {
			if (friend.get(0).equals(user))
				friendList.add(friend.get(1));
			else if (friend.get(1).equals(user))
				friendList.add(friend.get(0));
		}
		return friendList;
	}

	private static List<List<String>> makeFriendFriendList(String user, List<List<String>> friends,
		List<String> userFriendsList) {
		List<List<String>> userFriendsFriendsList = new ArrayList<>();
		for (String friend : userFriendsList) {
			List<String> friendList = makeFriendList(friends, friend);
			friendList.remove(user);
			userFriendsFriendsList.add(friendList);
		}
		return userFriendsFriendsList;
	}

	private static List<String> makeNoFriendList(List<String> userList, List<String> userFriendsList) {
		List<String> noFriendList = new ArrayList<>(userList);
		for (String friend : userFriendsList) {
			noFriendList.remove(friend);
		}
		return noFriendList;
	}

}
