package onboarding.problemseven.domain;

import java.util.HashSet;

public class User {
	private String name;
	private HashSet friends = new HashSet<>();

	public User(String name) {
		this.name = name;
	}

	public void addFriend(String friend){
		friends.add(friend);
	}
}
