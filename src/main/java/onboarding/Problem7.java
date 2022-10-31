package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = new ArrayList<>(Collections.emptyList());
		Map<String, Integer> dict = new HashMap<>(); // [사람 이름, 추천 점수]를 담을 HashMap
		Set<String> friendSet = new HashSet<>(); // 추천 친구 대상 set (사용자와 아직 친구가 아닌 사람들)
		Set<String> alreadyFriend = new HashSet<>(); // 사용자와 이미 친구인 사람들 set

		initFriendSet(user, friends, visitors, friendSet, alreadyFriend);

		alreadyFriend.remove(user); // 사용자 본인은 제외

		// HashMap 초기화
		for (String s : friendSet) {
			dict.put(s, 0);
		}

		// 추천 점수 계산
		calcScore(friends, visitors, dict, friendSet, alreadyFriend);

		// 추천 점수(value)가 0점인 사람(key)은 제외하기 위해 deleteKeys 선언
		Set<String> deleteKeys = new HashSet<>();
		for (Map.Entry<String, Integer> entry : dict.entrySet()) {
			if (entry.getValue() == 0) {
				deleteKeys.add(entry.getKey());
			}
		}
		deleteKeys.forEach(k -> dict.remove(k));

		// 정렬
		List<Map.Entry<String, Integer>> list = sortFriends(dict);

		// 추천 친구 이름을 리스트에 담아 반환
		for (Map.Entry<String, Integer> stringIntegerEntry : list) {
			answer.add(stringIntegerEntry.getKey());
		}

		return answer;
	}

	/**
	 * 추천 점수 순으로 정렬하고, 추천 점수가 같은 경우는 이름순으로 정렬하는 메서드
	 * 최대 5명만 리턴한다.
	 * @param dict
	 * @return
	 */
	private static List<Map.Entry<String, Integer>> sortFriends(Map<String, Integer> dict) {

		List<Map.Entry<String, Integer>> list = new LinkedList<>(dict.entrySet());
		list.sort((o1, o2) -> {
			// value 값 내림차순 정렬
			int comparison = (o1.getValue() - o2.getValue()) * -1;
			// value 값이 같으면 key 값 오름차순 정렬
			return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
		});

		// 정렬 후 5명 초과이면 최대 5명까지만
		while (list.size() > 5) {
			list.remove(list.size() - 1);
		}
		return list;
	}

	/**
	 * 추천 점수를 계산하는 메서드
	 * @param friends
	 * @param visitors
	 * @param dict
	 * @param friendSet
	 * @param alreadyFriend
	 */
	private static void calcScore(List<List<String>> friends, List<String> visitors, Map<String, Integer> dict,
		Set<String> friendSet, Set<String> alreadyFriend) {

		// 사용자와 함께 아는 친구 수 * 10점
		for (List<String> friend : friends) {
			for (String s : alreadyFriend) {
				if (friend.contains(s)) { // 사용자와 함께 아는 친구가 있다면
					String friend1 = friend.get(0); // friend 리스트의 첫 번째 요소
					String friend2 = friend.get(1); // friend 리스트의 두 번째 요소
					if (friendSet.contains(friend1)) {
						dict.put(friend1, dict.get(friend1) + 10); // friend1 의 친구 점수 + 10
					}
					if (friendSet.contains(friend2)) { // user 일 수도 있기 때문에 if~else 가 아닌 if 문을 두 번 사용해야 한다.
						dict.put(friend2, dict.get(friend2) + 10); // friend2 의 친구 점수 + 10
					}
				}
			}
		}

		// 사용자의 타임 라인에 방문한 횟수 * 1점
		for (String visitor : visitors) {
			if (friendSet.contains(visitor)) {
				dict.put(visitor, dict.get(visitor) + 1); // visitor 의 친구 점수 + 1
			}
		}
	}

	/**
	 * 친구 점수를 계산해야 하는 사람들로 friendSet 을 초기화하는 메서드
	 * (사용자 본인이거나 이미 친구인 사람들은 친구 점수를 계산할 필요가 없다.)
	 * (사용자 본인 혹은 이미 친구인 사람들은 alreadyFriend 에 담는다.)
	 * @param user
	 * @param friends
	 * @param visitors
	 * @param friendSet
	 * @param alreadyFriend
	 */
	private static void initFriendSet(String user, List<List<String>> friends, List<String> visitors,
		Set<String> friendSet,
		Set<String> alreadyFriend) {

		// friendSet 초기화
		for (List<String> friend : friends) {
			friendSet.addAll(friend);
			if (friend.contains(user)) { // 사용자 본인 & 사용자와 이미 친구인 사람들
				alreadyFriend.addAll(friend);
			}
		}
		friendSet.addAll(visitors);

		// 사용자 본인 & 사용자와 이미 친구인 사람들은 friendSet 에서 제외
		for (String s : alreadyFriend) {
			friendSet.remove(s);
		}
	}
}
