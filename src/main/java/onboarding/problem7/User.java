package onboarding.problem7;

import java.util.HashSet;
import java.util.Set;

public class User {
	private String name;
	private Set<User> friends = new HashSet<>();

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Set<User> getFriends() {
		return friends;
	}

	@Override
	public String toString() {
		return "User{" +
			"name='" + name + '\'' +
			'}';
	}
}
