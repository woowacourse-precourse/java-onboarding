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
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		scoreTable = new Hashtable<>();
		friendTable = new Hashtable<>();

		setFriendTable(friends);
//		scoreMutualFriends(user);
//		scoreVisitors(visitors);
//		removeUserAndFriends(user);
//		removeZeros();
//		return (getSortedList());
	}

}
