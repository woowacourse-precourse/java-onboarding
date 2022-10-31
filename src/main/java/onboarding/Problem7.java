package onboarding;

import java.util.*;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> myFriendList = findFriends(user, friends);
		List<List<String>> exceptFriendList = findnoFriends(user, friends);
		
		HashMap<String, Integer> scoreMap = new HashMap<>();
		for (List<String> relation : exceptFriendList) {
			if (myFriendList.contains(relation.get(0)) && !myFriendList.contains(relation.get(1))) {
				scoreMap = calculateScore(scoreMap, relation.get(1));
			}
			
			if (myFriendList.contains(relation.get(1)) && !myFriendList.contains(relation.get(0))) {
				scoreMap = calculateScore(scoreMap, relation.get(0));
			}
		}
		
		for (String visitorName : visitors) {
			if (myFriendList.contains(visitorName)) {
				continue;
			}
			
			if (!scoreMap.containsKey(visitorName)) {
				scoreMap.put(visitorName, 1);
			} else {
				int beforeScore = scoreMap.get(visitorName);
				scoreMap.put(visitorName, beforeScore + 1);
			}
		}
		
		List<String> result = mapToListWithSort(scoreMap);
		return result;
	}
	
	private static List<String> mapToListWithSort(HashMap<String, Integer> scoreMap) {
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scoreMap.entrySet());
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
			
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getValue() > o2.getValue()) {
					return -1;
				} else if (o1.getValue() < o2.getValue()) {
					return 1;
				} else {
					return dictionarySorting(o1, o2);
				}
			}
			
			private int dictionarySorting(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getKey().compareTo(o2.getKey()) > 0) {
					return 1;
				} else if (o1.getKey().compareTo(o2.getKey()) < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		ArrayList<String> result = new ArrayList<>();
		int i = 0;
		for (Map.Entry<String, Integer> entry : entryList) {
			if (i == 5) {
				break;
			}
			result.add(entry.getKey());
			i++;
		}
		
		return result;
	}
	
	
	private static HashMap<String, Integer> calculateScore(HashMap<String, Integer> scoreList, String s) {
		boolean flag = scoreList.containsKey(s);
		if (!flag) {
			scoreList.put(s, 10);
		} else {
			int beforeScore = scoreList.get(s);
			scoreList.put(s, beforeScore + 10);
		}
		return scoreList;
	}
	
	private static List<List<String>> findnoFriends(String user, List<List<String>> friends) {
		List<List<String>> exceptFriendList = new ArrayList<>();
		
		for (List<String> relationship : friends) {
			if (!relationship.get(0).equals(user) && !relationship.get(1).equals(user)) {
				exceptFriendList.add(relationship);
			}
		}
		
		return exceptFriendList;
	}
	
	private static List<String> findFriends(String user, List<List<String>> friends) {
		
		List<String> myFriendList = new ArrayList<>();
		
		for (List<String> relationship : friends) {
			if (relationship.get(0).equals(user)) {
				myFriendList.add(relationship.get(1));
			} else if (relationship.get(1).equals(user)) {
				myFriendList.add(relationship.get(0));
			}
		}
		
		return myFriendList;
	}
}
