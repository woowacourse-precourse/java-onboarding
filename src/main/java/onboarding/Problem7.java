package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
	static final int RANKING_LIST_SIZE_LIMIT = 5;

	static final int FRIEND_POINT = 10;
	static final int VISIT_POINT = 1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		HashMap<String, Integer> strangersAndPoints = makeHashMap(returnStrangers(user, friends, visitors));
		plusFriendPoint(user, friends, strangersAndPoints);
		plusVisitPoint(visitors, strangersAndPoints);
		return returnRankingList(strangersAndPoints);
	}

	private static List<String> returnRankingList(HashMap<String, Integer> strangersAndPoints) {
		List<String> rankingList = new ArrayList<>();
		List<Map.Entry<String, Integer>> strangersAndPointsList = new ArrayList<>(strangersAndPoints.entrySet());
		preprocessEntryList(strangersAndPointsList);
		if (strangersAndPointsList.size() > RANKING_LIST_SIZE_LIMIT) {
			strangersAndPointsList = strangersAndPointsList.subList(0, RANKING_LIST_SIZE_LIMIT);
		}
		strangersAndPointsList.forEach(strangerAndPoint -> rankingList.add(strangerAndPoint.getKey()));
		return rankingList;
	}

	private static void preprocessEntryList(List<Map.Entry<String, Integer>> entries) {
		entries.sort(Map.Entry.comparingByKey());
		entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		removeZeroValue(entries);
	}

	private static void removeZeroValue(List<Map.Entry<String, Integer>> entries) {
		entries.removeIf(x -> x.getValue() == 0);
	}

	private static void plusVisitPoint(List<String> visitors, HashMap<String, Integer> strangersAndPoints) {
		visitors.forEach(
			visitor -> strangersAndPoints.computeIfPresent(visitor, (stranger, point) -> point + VISIT_POINT));
	}

	private static void plusFriendPoint(String user, List<List<String>> friends,
		HashMap<String, Integer> strangersAndPoints) {
		strangersAndPoints.forEach((stranger, point) -> strangersAndPoints.put(stranger,
			point + returnCommonFriendNumber(user, stranger, friends) * FRIEND_POINT));
	}

	private static int returnCommonFriendNumber(String user, String person, List<List<String>> friends) {
		List<String> userFriends = returnFriendList(user, friends);
		List<String> personFriends = returnFriendList(person, friends);
		int commonFriendNumber = 0;
		commonFriendNumber += personFriends.stream().filter(userFriends::contains).count();
		return commonFriendNumber;
	}

	private static List<String> returnFriendList(String person, List<List<String>> friends) {
		HashSet<String> friendsSet = new HashSet<>();
		friends.stream()
			.filter(friend -> friend.contains(person))
			.forEach(friend -> friendsSet.add(
				friend.stream().filter(someone -> !someone.equals(person)).collect(Collectors.joining())));
		return new ArrayList<>(friendsSet);
	}

	private static HashMap<String, Integer> makeHashMap(List<String> strangers) {
		HashMap<String, Integer> strangersAndPoints = new HashMap<>();
		strangers.forEach(stranger -> strangersAndPoints.put(stranger, 0));
		return strangersAndPoints;
	}

	private static List<String> returnStrangers(String user, List<List<String>> friends, List<String> visitors) {
		List<String> strangers = new ArrayList<>();
		for (List<String> friend : friends) {
			strangers = addTargetToList(strangers, friend);
		}
		strangers = addTargetToList(strangers, visitors);
		strangers.remove(user);
		strangers = removeTargetFromList(strangers, returnFriendList(user, friends));
		return strangers;
	}

	private static List<String> removeTargetFromList(List<String> list, List<String> target) {
		return list.stream().filter(x -> !target.contains(x)).collect(Collectors.toList());
	}

	private static List<String> addTargetToList(List<String> list, List<String> target) {
		List<String> result = target.stream().filter(x -> !list.contains(x)).collect(Collectors.toList());
		result.addAll(list);
		return result;
	}
}
