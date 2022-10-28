package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();
		
		List<String> myFriendList = findFriends(user, friends);
		
		
		return answer;
	}
	
	private static List<String> findFriends(String user, List<List<String>> friends) {
		
		List<String> myFriendList = new ArrayList<>();
		
		for (List<String> relationship : friends) {
			if (relationship.get(0).equals(user)) {
				myFriendList.add(relationship.get(1));
			}
			if (relationship.get(1).equals(user)) {
				myFriendList.add(relationship.get(0));
			}
		}
		
		return myFriendList;
	}
}
