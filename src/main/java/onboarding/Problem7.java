package onboarding;

import java.util.*;

public class Problem7 {
	private static Hashtable<String, List<String>> friendTable;
	private static Hashtable<String, Integer> scoreTable;
	private static void setFriendTable(List<List<String>> friends) {
		String idA;
		String idB;
		List<String> listA;
		List<String> listB;

		for (List<String> relationship : friends) {
			idA = relationship.get(0);
			idB = relationship.get(1);
			friendTable.putIfAbsent(idA, new ArrayList<>());
			friendTable.putIfAbsent(idB, new ArrayList<>());
			listA = friendTable.get(idA);
			listA.add(idB);
			listB = friendTable.get(idB);
			listB.add(idA);
		}
	}
	private static int isMutualFriend(String user, List<String> friendList) {
		if (friendList.contains(user))
			return (1);
		return (0);
	}
	private static int countMutualFriend(String user, List<String> friendList) {
		int ret = 0;

		for (String id : friendList) {
			ret += isMutualFriend(user, friendTable.get(id));
		}
		return (ret);
	}
	private static void scoreMutualFriends(String user) {
		Set<Map.Entry<String, List<String>>> entrySet = friendTable.entrySet();
		String id;
		List<String> friendsOfId;

		for (Map.Entry<String, List<String>> entry : entrySet) {
			id = entry.getKey();
			friendsOfId = entry.getValue();
			scoreTable.put(id, 10 * countMutualFriend(user, friendsOfId));
		}
	}
	private static void scoreVisitors(List<String> visitors) {
		int score;

		for (String visitor : visitors) {
			score = scoreTable.getOrDefault(visitor, 0);
			scoreTable.put(visitor, score + 1);
		}
	}
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		scoreTable = new Hashtable<>();
		friendTable = new Hashtable<>();

		setFriendTable(friends);
		scoreMutualFriends(user);
		scoreVisitors(visitors);
//		removeUserAndFriends(user);
//		removeZeros();
//		return (getSortedList());
	}

}
