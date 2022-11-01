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

	public static final int MAX_RETURN_SIZE = 5;
	public static final int BOTH_KNOW_SCORE = 10;
	public static final int TIMELINE_VISIT_SCORE = 1;

	public static final int EXCEPTION = -1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = new ArrayList<>(Collections.emptyList());
		Map<String, Integer> nameAndScores = new HashMap<>();
		Set<String> notYetFriendWithUser;
		Set<String> alreadyFriendWithUser = new HashSet<>();

		if (checkRestrictions(user, friends, visitors) == EXCEPTION) {
			return answer;
		}

		notYetFriendWithUser = initNotYetFriendWithUser(user, friends, visitors, alreadyFriendWithUser);
		alreadyFriendWithUser.remove(user);

		for (String friend : notYetFriendWithUser) {
			nameAndScores.put(friend, 0);
		}

		calcScore(friends, visitors, nameAndScores, notYetFriendWithUser, alreadyFriendWithUser);

		Set<String> zeroPoints = new HashSet<>();
		for (Map.Entry<String, Integer> entry : nameAndScores.entrySet()) {
			if (entry.getValue() == 0) {
				zeroPoints.add(entry.getKey());
			}
		}
		zeroPoints.forEach(k -> nameAndScores.remove(k));

		List<Map.Entry<String, Integer>> sortedFriends = sortFriends(nameAndScores);

		for (Map.Entry<String, Integer> stringIntegerEntry : sortedFriends) {
			answer.add(stringIntegerEntry.getKey());
		}

		return answer;
	}

	private static Integer checkRestrictions(String user, List<List<String>> friends, List<String> visitors) {
		if (!isUserRangeValid(user)) {
			return EXCEPTION;
		}
		if (!isFriendsRangeValid(friends)) {
			return EXCEPTION;
		}
		if (!isIdRangeValid(friends)) {
			return EXCEPTION;
		}
		if (!isVisitorsRangeValid(visitors)) {
			return EXCEPTION;
		}
		if (!isIdLowerCase(friends)) {
			return EXCEPTION;
		}
		return 0;
	}

	private static boolean isUserRangeValid(String user) {
		if (user.length() < 1 || user.length() > 30) {
			return false;
		}
		return true;
	}

	private static boolean isFriendsRangeValid(List<List<String>> friends) {
		if (friends.size() < 1 || friends.size() > 10000) {
			return false;
		}
		return true;
	}

	private static boolean isIdRangeValid(List<List<String>> friends) {
		for (List<String> friend : friends) {
			for (String id : friend) {
				if (id.length() < 1 || id.length() > 30) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isVisitorsRangeValid(List<String> visitors) {
		if (visitors.size() > 10000) {
			return false;
		}
		return true;
	}

	private static boolean isIdLowerCase(List<List<String>> friends) {
		for (List<String> friend : friends) {
			for (String id : friend) {
				if (!id.equals(id.toLowerCase())) {
					return false;
				}
			}
		}
		return true;
	}

	private static List<Map.Entry<String, Integer>> sortFriends(Map<String, Integer> nameAndScores) {

		List<Map.Entry<String, Integer>> friends = new LinkedList<>(nameAndScores.entrySet());
		friends.sort((o1, o2) -> {
			int comparison = (o1.getValue() - o2.getValue()) * -1;
			return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
		});

		while (friends.size() > MAX_RETURN_SIZE) {
			friends.remove(friends.size() - 1);
		}
		return friends;
	}

	private static void calcScore(List<List<String>> friends, List<String> visitors, Map<String, Integer> nameAndScores,
		Set<String> notYetFriendWithUser, Set<String> alreadyFriendWithUser) {
		calcBothKnowScore(friends, nameAndScores, notYetFriendWithUser, alreadyFriendWithUser);
		calcVisitScore(visitors, nameAndScores, notYetFriendWithUser);
	}

	private static void calcVisitScore(List<String> visitors, Map<String, Integer> nameAndScores,
		Set<String> notYetFriendWithUser) {
		for (String visitor : visitors) {
			if (notYetFriendWithUser.contains(visitor)) {
				nameAndScores.put(visitor, nameAndScores.get(visitor) + TIMELINE_VISIT_SCORE);
			}
		}
	}

	private static void calcBothKnowScore(List<List<String>> friends, Map<String, Integer> nameAndScores,
		Set<String> notYetFriendWithUser, Set<String> alreadyFriendWithUser) {
		for (List<String> friend : friends) {
			for (String alreadyFriend : alreadyFriendWithUser) {
				for (String person : friend) {
					if (friend.contains(alreadyFriend)
						&& notYetFriendWithUser.contains(person)) {
						nameAndScores.put(person, nameAndScores.get(person) + BOTH_KNOW_SCORE);
					}
				}
			}
		}
	}

	private static Set<String> initNotYetFriendWithUser(String user, List<List<String>> friends, List<String> visitors,
		Set<String> alreadyFriendWithUser) {
		Set<String> notYetFriendWithUser = new HashSet<>();

		for (List<String> friend : friends) {
			notYetFriendWithUser.addAll(friend);
			if (friend.contains(user)) {
				alreadyFriendWithUser.addAll(friend);
			}
		}
		notYetFriendWithUser.addAll(visitors);

		for (String s : alreadyFriendWithUser) {
			notYetFriendWithUser.remove(s);
		}
		return notYetFriendWithUser;
	}
}
