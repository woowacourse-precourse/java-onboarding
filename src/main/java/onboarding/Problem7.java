package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

		LinkedHashMap<String, Integer> countingMap = new LinkedHashMap<String, Integer>();
		List<String> notToCountName = new ArrayList<>();


		/**
		 * friends 점수 카운팅 기능
		 */
		for (int i = 0; i < friends.size(); i++) {
			List friendsList = friends.get(i);

			for (int j = 0; j < 2; j++) {
				String friendName = (String) friendsList.get(j);
				String pairName = getPairName(friendsList, j);

				for (int k = 0; k < friends.size(); k++) {
					if (k == i) {
					} else {
						List otherFriendsList = friends.get(k);
						if (otherFriendsList.contains(friendName) == true && otherFriendsList.contains(user) == true) {
							notToCountName.add(friendName);
							break;
						} else if (pairName == user) {
							notToCountName.add(pairName);
							break;
						} else if (otherFriendsList.contains(pairName) == true && otherFriendsList.contains(user) == true) {
							countingMap.merge(friendName, 10, (integer, integer2) -> integer + integer2);
						}
					}
				}
			}
		}


		notToCountName = removeDuplication(notToCountName);


		/**
		 * visitors 점수 카운팅 기능
		 */

		for (int i = 0; i < visitors.size(); i++) {
			String visitorsName = visitors.get(i);
			if (notToCountName.contains(visitorsName)) {
			} else {
				countingMap.merge(visitorsName, 1, (integer, integer2) -> integer + integer2);
			}
		}


		/**
		 *  출력 조건 설정
		 *  1) 높은순 정렬
		 *  2) 5명 미만으로 제한
		 *  3) 추천 점수가 0점인 경우 제외
		 *  4) 추천 점수가 같으면 이름순 정렬
		 */

		int limit = 5;
		countingMap = sortByDescendingOrder(countingMap, limit);
		countingMap = removeIfCountEqualsZero(countingMap);
		List<Map.Entry<String, Integer>> countingList = sortByAlphabeticalOrder(countingMap);
		List<String> answer = fixStringAndReturn(countingList);


		return answer;
	}

	private static List<String> fixStringAndReturn(List<Map.Entry<String, Integer>> countingList) {
		List<String> answer = new ArrayList<>();
		String regex = "=[0-9]+";
		for (int i = 0; i < countingList.size(); i++) {
			String returnValue = String.valueOf(countingList.get(i)).replaceAll(regex, "");
			answer.add(returnValue);
		}
		return answer;
	}

	private static List<Map.Entry<String, Integer>> sortByAlphabeticalOrder(LinkedHashMap<String, Integer> countingMap) {
		List<Map.Entry<String, Integer>> list = new LinkedList<>(
				countingMap.entrySet());
		Collections.sort(list,
				(map1, map2) -> map1.getKey().compareTo(map2.getKey())
		);
		Collections.sort(list,
				(map1, map2) -> map2.getValue().compareTo(map1.getValue())
		);
		return list;
	}

	private static LinkedHashMap<String, Integer> removeIfCountEqualsZero(LinkedHashMap<String, Integer> countingMap) {
		LinkedHashMap<String, Integer> zeroRemoveCountingMap = countingMap;

		countingMap.entrySet().removeIf(entry -> "0".equalsIgnoreCase(String.valueOf(entry.getValue())));

		return zeroRemoveCountingMap;
	}


	private static LinkedHashMap<String, Integer> sortByDescendingOrder(LinkedHashMap<String, Integer> countingMap, int limit) {
		LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
		countingMap.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.limit(limit)
				.forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

		return reverseSortedMap;
	}


	private static String getPairName(List friendsList, int j) {

		if (j == 0) {
			j = 1;
		} else if (j == 1) {
			j = 0;
		}
		String pairName = (String) friendsList.get(j);

		return pairName;
	}

	private static List<String> removeDuplication(List<String> selectedList) {
		List<String> answer = new ArrayList<String>();
		answer = selectedList.stream().distinct().collect(Collectors.toList());
		return answer;
	}
}
