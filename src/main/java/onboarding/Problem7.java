package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class Problem7 {

	private static final int LIMIT = 5;
	private static final int FIRST_FRIEND_AT_FRIEND_LIST = 0;
	private static final int SECOND_FRIEND_AT_FRIEND_LIST = 1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

		LinkedHashMap<String, Integer> countingMap = new LinkedHashMap<>();
		List<String> notToCountName = new ArrayList<>();

		/*
		  friends 점수 카운팅 기능
		 */

		calculatePointsByFriendsLogic(user, friends, countingMap, notToCountName);


		/*
		  visitors 점수 카운팅 기능
		 */

		calculatePointsByVisitorsLogic(visitors, countingMap, notToCountName);

		/*
		   출력 조건 설정
		   1) 높은순 정렬
		   2) 5명 미만으로 제한
		   3) 추천 점수가 0점인 경우 제외
		   4) 추천 점수가 같으면 이름순 정렬
		 */

		List<String> answer = setUpConstraintsForTheAnswer(countingMap);

		return answer;
	}

	private static List<String> setUpConstraintsForTheAnswer(LinkedHashMap<String, Integer> countingMap) {
		countingMap = sortByDescendingOrder(countingMap);
		removeIfCountEqualsZero(countingMap);
		List<Map.Entry<String, Integer>> countingList = sortByAlphabeticalOrder(countingMap);
		return fixStringAndReturn(countingList);
	}


	private static void calculatePointsByFriendsLogic(String user, List<List<String>> friends, LinkedHashMap<String, Integer> countingMap, List<String> notToCountName) {

		for (int i = 0; i < friends.size(); i++) {
			checkEachNameAsPairs(user, friends, countingMap, notToCountName, i);
		}

	}

	private static void checkEachNameAsPairs(String user, List<List<String>> friends, LinkedHashMap<String, Integer> countingMap, List<String> notToCountName, int i) {
		List<String> friendsList = friends.get(i);

		for (int j = 0; j < 2; j++) {
			String friendName = friendsList.get(j);
			String pairName = getPairName(friendsList, j);
			addUpPointsByFriendsLogic(user, friends, countingMap, notToCountName, i, friendName, pairName);
		}

	}

	private static void addUpPointsByFriendsLogic(String user, List<List<String>> friends, LinkedHashMap<String, Integer> countingMap, List<String> notToCountName, int i, String friendName, String pairName) {

		for (int k = 0; k < friends.size(); k++) {

			if (k != i) {
				List<String> otherFriendsList = friends.get(k);

				if (otherFriendsList.contains(friendName) && otherFriendsList.contains(user)) {
					notToCountName.add(friendName);
					break;

				}

				if (Objects.equals(pairName, user)) {
					notToCountName.add(pairName);
					break;

				}

				if (otherFriendsList.contains(pairName) && otherFriendsList.contains(user)) {
					countingMap.merge(friendName, 10, Integer::sum);
				}

			}
		}

	}

	private static void calculatePointsByVisitorsLogic(List<String> visitors, LinkedHashMap<String, Integer> countingMap, List<String> notToCountName) {
		notToCountName = removeDuplication(notToCountName);

		for (String visitorsName : visitors) {

			addUpPointsByVisitorsLogic(countingMap, notToCountName, visitorsName);
		}

	}

	private static void addUpPointsByVisitorsLogic(LinkedHashMap<String, Integer> countingMap, List<String> notToCountName, String visitorsName) {

		if (!notToCountName.contains(visitorsName)) {
			countingMap.merge(visitorsName, 1, Integer::sum);
		}

	}

	private static List<String> fixStringAndReturn(List<Map.Entry<String, Integer>> countingList) {
		List<String> answer = new ArrayList<>();
		String regex = "=[0-9]+";

		for (Map.Entry<String, Integer> stringIntegerEntry : countingList) {
			String returnValue = String.valueOf(stringIntegerEntry).replaceAll(regex, "");
			answer.add(returnValue);
		}

		return answer;
	}

	private static List<Map.Entry<String, Integer>> sortByAlphabeticalOrder(LinkedHashMap<String, Integer> countingMap) {
		List<Map.Entry<String, Integer>> list = new LinkedList<>(
				countingMap.entrySet());
		list.sort(Map.Entry.comparingByKey());
		list.sort((map1, map2) -> map2.getValue().compareTo(map1.getValue()));
		return list;
	}

	private static void removeIfCountEqualsZero(LinkedHashMap<String, Integer> countingMap) {
		countingMap.entrySet().removeIf(entry -> "0".equalsIgnoreCase(String.valueOf(entry.getValue())));
	}


	private static LinkedHashMap<String, Integer> sortByDescendingOrder(LinkedHashMap<String, Integer> countingMap) {
		LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
		countingMap.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.limit(Problem7.LIMIT)
				.forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
		return reverseSortedMap;
	}


	private static String getPairName(List<?> friendsList, int j) {

		if (j == FIRST_FRIEND_AT_FRIEND_LIST) {
			return (String) friendsList.get(SECOND_FRIEND_AT_FRIEND_LIST);
		}

		if (j == SECOND_FRIEND_AT_FRIEND_LIST) {
			return (String) friendsList.get(FIRST_FRIEND_AT_FRIEND_LIST);
		}

		return (String) friendsList.get(j);
	}

	private static List<String> removeDuplication(List<String> selectedList) {
		List<String> answer;
		answer = selectedList.stream().distinct().collect(Collectors.toList());
		return answer;
	}

}
