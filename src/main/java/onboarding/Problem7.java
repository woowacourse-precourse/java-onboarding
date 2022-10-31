package onboarding;

import java.util.*;
import java.util.stream.Collectors;


public class Problem7 {
	
	/* 
	 * 사용자와 함께 아는 친구의 수 = 10점 / 사용자의 타임 라인에 방문한 횟수 = 1점
	 * 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬
	 * 점수가 가장 높은 순으로 정렬하여 최대 5명을 return
	 */

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = new ArrayList<>();
		List<String> userFriend = new ArrayList<>();
		Map<String, Integer> userScore = new HashMap<>();

		// user의 친구 리스트 추가
		for (List<String> friend : friends) {
			if (friend.get(0).equals(user)) {
				userFriend.add(friend.get(1));
			} else if (friend.get(1).equals(user)) {
				userFriend.add(friend.get(0));
			}
		}
		// 친구들 중복제거
		for (List<String> friend : friends) {
			for (int i = 0; i < friend.size(); i++) {
				userScore.put(friend.get(i), 0);
			}
		}
		// 방문자 / = 점수 + 1
		for (String visitor : visitors) {
			if (userScore.containsKey(visitor)) {
				userScore.put(visitor, userScore.get(visitor) + 1);
			} else {
				userScore.put(visitor, 1);
			}
		}
		// 친구의 친구는 / 점수 + 10
		for (List<String> friend : friends) {
			if (userFriend.contains(friend.get(0)) && userScore.containsKey(friend.get(1))) {
				userScore.put(friend.get(1), userScore.get(friend.get(1)) + 10);
			} else if (userFriend.contains(friend.get(1)) && userScore.containsKey(friend.get(0))) {
				userScore.put(friend.get(0), userScore.get(friend.get(0)) + 10);
			}
		}
		// 유저 삭제
		userScore.remove(user);
		// 이미 친구인 사람들은 제외
		for (int i = 0; i < userFriend.size(); i++) {
			if (userScore.containsKey(userFriend.get(i))) {
				userScore.remove(userFriend.get(i));
			}
		}
		return setScore(userScore);

	}

	// 유저이름 정렬 / 점수 순 정렬
	public static List<String> setScore(Map<String, Integer> userScore) {
		// 점수가 0 이하는 삭제
		List<String> answer = userScore.entrySet().stream().filter(entry -> entry.getValue() > 0)
				.map(entry -> entry.getKey()).collect(Collectors.toList());
		// 이름 순 정렬
		Collections.sort(answer);
		// 점수 순 정렬
		answer.sort((value1, value2) -> (userScore.get(value2) - userScore.get(value1)));
		// 길이가 5이상이면 5까지만 출력
		if (answer.size() > 5) {
			answer = answer.subList(0, 5);
		}
		return answer;

	}

}
