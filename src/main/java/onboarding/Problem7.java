package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

	public static List<String> solution(String user, List<List<String>> friends,
		List<String> visitors) {
		List<String> answer = Collections.emptyList();

		List<String> friendsOfUser = makeFriendList(user, friends);
		HashMap<String, Integer> recommendNameWithScoreMap = makeRecommendList(user, friendsOfUser,
			friends);
		recommendNameWithScoreMap = addVisitorScore(recommendNameWithScoreMap, visitors,
			friendsOfUser);

		answer = sortHashMapAndConvert(recommendNameWithScoreMap);

		return answer;
	}

	/**
	 * 기능 1 user의 친구 리스트 생성
	 */
	public static List<String> makeFriendList(String user, List<List<String>> friends) {
		List<String> friendsOfUser = new ArrayList<>();

		for (int i = 0; i < friends.size(); i++) {

			String leftFriendName = friends.get(i).get(0);
			String rightFriendName = friends.get(i).get(1);

			if (leftFriendName.equals(user)) { // friends 리스트의 왼쪽의 이름이 유저와 같을 때
				friendsOfUser.add(rightFriendName); // 유저 친구 리스트에 오른쪽 친구의 이름 입력
			}
			if (rightFriendName.equals(user)) { // friends 리스트의 오른쪽의 이름이 유저와 같을 때
				friendsOfUser.add(leftFriendName); // 유저 친구 리스트에 왼쪽 친구의 이름 입력
			}
		}

		return friendsOfUser;
	}

	/**
	 * 기능 2 사용자와 함께 아는 친구를 가진 사람과 점수 Map 생성
	 */
	public static HashMap<String, Integer> makeRecommendList(String user,
		List<String> friendsOfUser, List<List<String>> friends) {

		HashMap<String, Integer> recommendNameWithScoreMap = new HashMap<>(); // 추천할 사람의 이름과 점수가 담긴 Map

		for (int i = 0; i < friendsOfUser.size(); i++) {

			String friendName = friendsOfUser.get(i); //이미 유저와 친구인 사람의 이름

			for (int j = 0; j < friends.size(); j++) {

				String leftFriendName = friends.get(j).get(0); // 리스트의 왼쪽 사람의 이름
				String rightFriendName = friends.get(j).get(1);// 리스트의 오른쪽 사람의 이름

				if (leftFriendName.equals(friendName) && !rightFriendName.equals(user)) { // 왼쪽 이름이 이미 유저의 친구이고, 오른쪽 사람이 유저가 아닐 경우
					if (recommendNameWithScoreMap.containsKey(rightFriendName)) { // 오른쪽 사람이 이미 추천 Map에 있는 경우
						recommendNameWithScoreMap.put(rightFriendName,
							recommendNameWithScoreMap.get(rightFriendName) + 10); // 10점 추가
					} else { //오른쪽 사람이 추천 Map에 없는 경우
						recommendNameWithScoreMap.put(rightFriendName, 10); // 오른쪽 사람의 이름과 점수 10점으로 입력
					}
				}
				if (rightFriendName.equals(friendsOfUser.get(i)) && !leftFriendName.equals(user)) {
					if (recommendNameWithScoreMap.containsKey(leftFriendName)) {
						recommendNameWithScoreMap.put(leftFriendName,
							recommendNameWithScoreMap.get(leftFriendName) + 10);
					} else {
						recommendNameWithScoreMap.put(leftFriendName, 10);
					}
				}
			}
		}

		return recommendNameWithScoreMap;
	}

	/**
	 * 기능 3 기능 2에 만든 리스트에 방문자 리스트 및 점수 추가
	 */
	public static HashMap<String, Integer> addVisitorScore(
		HashMap<String, Integer> recommendNameWithScoreMap,
		List<String> visitor,
		List<String> friendsOfUser) {

		for (int i = 0; i < visitor.size(); i++) {

			String visitorName = visitor.get(i); // 방문자의 이름
			if (recommendNameWithScoreMap.containsKey(visitorName)) { // 추천 Map에 이미 방문자의 이름이 존재하는 경우
				recommendNameWithScoreMap.put(visitorName,
					recommendNameWithScoreMap.get(visitorName) + 1); // 1점 추가
			} else if (!friendsOfUser.contains(visitorName)) { // 추천 Map에 방문자 이름이 없고, 이미 친구가 아닌 경우
				recommendNameWithScoreMap.put(visitorName, 1); // 추천 Map에 이름과 1점으로 저장
			}
		}

		return recommendNameWithScoreMap;
	}


	/**
	 * 기능 4 점수가 높은 순서대로 정렬 및 Map -> List
	 */
	public static List<String> sortHashMapAndConvert(
		HashMap<String, Integer> recommendNameWithScore) {

		List<String> rankOfRecommend = new ArrayList<>(recommendNameWithScore.keySet()); //추천 Map의 Key(이름)을 List로 변환

		rankOfRecommend.sort(
			((o1, o2) -> recommendNameWithScore.get(o2).compareTo(recommendNameWithScore.get(o1)))); // 리스트를 Value값으로 내림차순 정렬

		return rankOfRecommend.stream().limit(5).collect(Collectors.toList()); // 리스트를 상위 5명만 나오도록 수정
	}

}
