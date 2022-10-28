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
	
}
