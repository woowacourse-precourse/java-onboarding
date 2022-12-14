package onboarding;

import static onboarding.enums.problem7.Point.*;

import java.util.*;

public class Problem7 {
	public static final int MAX_FRIEND_RECOMMEND = 5;
	public static final int INIT_ZERO = 0;
	public static List<String> userFriend;
	public static Map<String, Integer> recommendCandidate;
	public static List<String> result;
	public static List<String> samePointList;
	public static String currentUser;
	public static int count;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		init(user);

		findUserFriend(friends);
		findSameFriend(friends);
		findVisitor(visitors);

		return makeOrder();
	}

	public static void init(String user) {
		currentUser = user;
		userFriend = new ArrayList<>();
		recommendCandidate = new HashMap<>();
		result = new ArrayList<>();
		samePointList = new ArrayList<>();
		count = INIT_ZERO;
	}

	public static List<String> orderSamePointFriend(List<Map.Entry<String, Integer>> listEntries) {
		for (int targetIndex = INIT_ZERO; targetIndex < listEntries.size(); targetIndex++) {
			if (count >= MAX_FRIEND_RECOMMEND) {
				return result;
			}

			checkSamePointFriend(listEntries, targetIndex, listEntries.get(targetIndex).getValue());
			targetIndex = (samePointList.isEmpty() ? empty(listEntries, targetIndex) :
				notEmpty(listEntries, targetIndex));
		}
		return result;
	}

	private static int empty(List<Map.Entry<String, Integer>> listEntries, int targetIndex) {
		result.add(listEntries.get(targetIndex).getKey());
		count++;

		return targetIndex;
	}

	public static int notEmpty(List<Map.Entry<String, Integer>> listEntries, int targetIndex) {
		orderSamePointName(listEntries, targetIndex);
		addSamePointNameInResult();
		targetIndex += (samePointList.size() - 1);
		samePointList.clear();

		return targetIndex;
	}

	private static void orderSamePointName(List<Map.Entry<String, Integer>> listEntries, int targetIndex) {
		samePointList.add(listEntries.get(targetIndex).getKey());
		Collections.sort(samePointList);
	}

	private static void addSamePointNameInResult() {
		for (String s : samePointList) {
			result.add(s);
			count++;
		}
	}

	public static void checkSamePointFriend(List<Map.Entry<String, Integer>> listEntries, int targetIndex,
		int targetPoint) {
		for (int compareIndex = targetIndex + 1; compareIndex < listEntries.size(); compareIndex++) {
			if (listEntries.get(compareIndex).getValue() == targetPoint) {
				samePointList.add(listEntries.get(compareIndex).getKey());
			}
		}
	}

	public static List<String> makeOrder() {
		List<Map.Entry<String, Integer>> listEntries = new ArrayList<Map.Entry<String, Integer>>(
			recommendCandidate.entrySet());

		Collections.sort(listEntries, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});

		return orderSamePointFriend(listEntries);
	}

	public static void findVisitor(List<String> visitors) {
		for (String visitor : visitors) {
			if (isStranger(visitor)) {
				checkExistName(visitor);
				addRecommendCandidate(visitor, ONE_POINT.getNumber());
			}
		}
	}

	public static void findSameFriend(List<List<String>> friends) {
		for (List<String> friendList : friends) {
			for (String name : friendList) {
				if (isStranger(name)) {
					checkExistName(name);
					addRecommendCandidate(name, FRIEND_POINT.getNumber());
				}
			}
		}
	}

	private static boolean isStranger(String name) {
		return !isSameWithUser(name) && !isSameWithUserFriend(name);
	}

	public static void addRecommendCandidate(String name, int point) {
		recommendCandidate.put(name, recommendCandidate.get(name) + point);
	}

	public static void checkExistName(String name) {
		if (!isExistName(name)) {
			recommendCandidate.put(name, ZERO_POINT.getNumber());
		}
	}

	public static boolean isExistName(String name) {
		return recommendCandidate.containsKey(name);
	}

	public static boolean isSameWithUserFriend(String name) {
		return userFriend.contains(name);
	}

	public static boolean isSameWithUser(String name) {
		return name.equals(currentUser);
	}

	public static void findUserFriend(List<List<String>> friends) {
		for (List<String> friendList : friends) {
			for (String friend : friendList) {
				addUserFriend(friend, friendList);
			}
		}
	}

	public static void addUserFriend(String friend, List<String> friendList) {
		if (isUserFriend(friend, friendList)) {
			userFriend.add(friend);
		}
	}

	public static boolean isUserFriend(String friend, List<String> friendList) {
		return (friendList.contains(currentUser) && !friend.equals(currentUser));
	}
}