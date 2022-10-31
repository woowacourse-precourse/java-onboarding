package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		HashMap<String, Integer> peopleAndPointMap = makeHashMap(makePeopleList(user, friends, visitors));
		plusFriendPoint(user, friends, peopleAndPointMap);
		plusVisitPoint(visitors, peopleAndPointMap);
		return returnRankingList(peopleAndPointMap);
	}

	private static List<String> returnRankingList(HashMap<String, Integer> peopleAndPointMap) {
		List<String> rankingList = new ArrayList<>();
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(peopleAndPointMap.entrySet());
		entryList.sort(Map.Entry.comparingByKey());
		entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		removeZeroValue(entryList);
		if (entryList.size() > 5) {
			for (int i = 0; i < 5; i++) {
				rankingList.add(entryList.get(i).getKey());
			}
			return rankingList;
		}
		for (Map.Entry<String, Integer> stringIntegerEntry : entryList) {
			rankingList.add(stringIntegerEntry.getKey());
		}
		return rankingList;
	}

	private static void removeZeroValue(List<Map.Entry<String, Integer>> entryList) {
		entryList.removeIf(x -> x.getValue() == 0);
	}

	private static void plusVisitPoint(List<String> visitors, HashMap<String, Integer> peopleAndPointMap) {
		visitors.forEach(visitor -> peopleAndPointMap.computeIfPresent(visitor, (people, point) -> point + 1));
	}

	private static void plusFriendPoint(String user, List<List<String>> friends,
		HashMap<String, Integer> peopleAndPointMap) {
		peopleAndPointMap.forEach((people, point) ->
			peopleAndPointMap.put(people, point + returnCommonFriendNumber(user, people, friends) * 10));
	}

	private static int returnCommonFriendNumber(String user, String people, List<List<String>> friends) {
		List<String> userFriendList = returnFriendList(user, friends);
		List<String> peopleFriendList = returnFriendList(people, friends);
		int commonFriendNumber = 0;
		for (String friend : peopleFriendList) {
			if (userFriendList.contains(friend)) {
				commonFriendNumber += 1;
			}
		}
		return commonFriendNumber;
	}

	private static List<String> returnFriendList(String people, List<List<String>> friends) {
		List<String> friendList = new ArrayList<>();
		for (List<String> friend : friends) {
			if (people.equals(friend.get(0))) {
				friendList.add(friend.get(1));
			}
			if (people.equals(friend.get(1))) {
				friendList.add(friend.get(0));
			}
		}
		return friendList;
	}

	private static HashMap<String, Integer> makeHashMap(List<String> peopleList) {
		HashMap<String, Integer> peopleAndPointMap = new HashMap<>();
		peopleList.forEach(x -> peopleAndPointMap.put(x, 0));
		return peopleAndPointMap;
	}

	private static List<String> makePeopleList(String user, List<List<String>> friends, List<String> visitors) {
		List<String> peopleList = new ArrayList<>();
		for (List<String> friend : friends) {
			peopleList = addToList(peopleList, friend);
		}
		peopleList = addToList(peopleList, visitors);
		peopleList.remove(user);
		peopleList = removeFromList(peopleList, returnFriendList(user, friends));
		return peopleList;
	}

	private static List<String> removeFromList(List<String> list, List<String> target) {
		return list.stream()
			.filter(x -> !target.contains(x))
			.collect(Collectors.toList());
	}

	private static List<String> addToList(List<String> list, List<String> target) {
		List<String> tmp = target.stream()
			.filter(x -> !list.contains(x))
			.collect(Collectors.toList());
		tmp.addAll(list);
		return tmp;
	}
}
