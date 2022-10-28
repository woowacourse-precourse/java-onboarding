package onboarding.problem7;

import java.util.HashMap;
import java.util.List;

public class Sns {
	public static final HashMap<String, User> registeredUsers = new HashMap<>();

	private static void addUserFromRelation(List<List<String>> relations) {
		for (List<String> relation : relations) {
			for (String userName : relation) {
				registeredUsers.putIfAbsent(userName, new User(userName));
			}
		}
	}

	private static void addUserFromVisit(List<String> visitors) {
		visitors.stream().forEach(userName -> registeredUsers.putIfAbsent(userName, new User(userName)));
	}

	private static void addFriend(List<List<String>> friends) {
		for (List<String> friend : friends) {
			User userOne = registeredUsers.get(friend.get(0));
			User userTwo = registeredUsers.get(friend.get(1));
			registeredUsers.get(userOne.getName()).getFriends().add(userTwo);
			registeredUsers.get(userTwo.getName()).getFriends().add(userOne);
		}
	}
	
}
