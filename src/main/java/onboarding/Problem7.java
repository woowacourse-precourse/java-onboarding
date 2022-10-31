package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		HashMap<String, Integer> strangersAndPointMap = makeHashMap(makeStrangersList(user, friends, visitors));
		plusFriendPoint(user, friends, strangersAndPointMap);
		plusVisitPoint(visitors, strangersAndPointMap);
		return returnRankingList(strangersAndPointMap);
	}

	private static List<String> returnRankingList(HashMap<String, Integer> strangersAndPointMap) {
		List<String> rankingList = new ArrayList<>();
		List<Map.Entry<String, Integer>> strangersAndPointList = new ArrayList<>(strangersAndPointMap.entrySet());
		preprocessEntryList(strangersAndPointList);
		if (strangersAndPointList.size() > 5) {
			strangersAndPointList = strangersAndPointList.subList(0, 5);
		}
		strangersAndPointList.forEach(strangerAndPoint -> rankingList.add(strangerAndPoint.getKey()));
		return rankingList;
	}

	private static void preprocessEntryList(List<Map.Entry<String, Integer>> entryList) {
		entryList.sort(Map.Entry.comparingByKey());
		entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		removeZeroValue(entryList);
	}

	private static void removeZeroValue(List<Map.Entry<String, Integer>> entryList) {
		entryList.removeIf(x -> x.getValue() == 0);
	}

	private static void plusVisitPoint(List<String> visitors, HashMap<String, Integer> strangersAndPointMap) {
		visitors.forEach(visitor -> strangersAndPointMap.computeIfPresent(visitor, (stranger, point) -> point + 1));
	}

	private static void plusFriendPoint(String user, List<List<String>> friends,
		HashMap<String, Integer> strangersAndPointMap) {
		strangersAndPointMap.forEach((stranger, point) ->
			strangersAndPointMap.put(stranger, point + returnCommonFriendNumber(user, stranger, friends) * 10));
	}

	private static int returnCommonFriendNumber(String user, String person, List<List<String>> friends) {
		List<String> userFriendList = returnFriendList(user, friends);
		List<String> peopleFriendList = returnFriendList(person, friends);
		int commonFriendNumber = 0;
		commonFriendNumber += peopleFriendList.stream()
			.filter(userFriendList::contains)
			.count();
		return commonFriendNumber;
	}

	private static List<String> returnFriendList(String person, List<List<String>> friends) {
		HashSet<String> friendList = new HashSet<>();
		friends.stream()
			.filter(friend -> friend.contains(person))
			.forEach(
				friend -> friendList.add(friend.stream().filter(x -> !x.equals(person)).collect(Collectors.joining())));
		return new ArrayList<>(friendList);
	}

	private static HashMap<String, Integer> makeHashMap(List<String> strangersList) {
		HashMap<String, Integer> strangersAndPointMap = new HashMap<>();
		strangersList.forEach(x -> strangersAndPointMap.put(x, 0));
		return strangersAndPointMap;
	}

	private static List<String> makeStrangersList(String user, List<List<String>> friends, List<String> visitors) {
		List<String> strangersList = new ArrayList<>();
		for (List<String> friend : friends) {
			strangersList = addTargetToList(strangersList, friend);
		}
		strangersList = addTargetToList(strangersList, visitors);
		strangersList.remove(user);
		strangersList = removeTargetFromList(strangersList, returnFriendList(user, friends));
		return strangersList;
	}

	private static List<String> removeTargetFromList(List<String> list, List<String> target) {
		return list.stream()
			.filter(x -> !target.contains(x))
			.collect(Collectors.toList());
	}

	private static List<String> addTargetToList(List<String> list, List<String> target) {
		List<String> tmp = target.stream()
			.filter(x -> !list.contains(x))
			.collect(Collectors.toList());
		tmp.addAll(list);
		return tmp;
	}
}
