package onboarding.problem7;

import java.util.List;

public class SNSSystem {
	private final UsersList users;

	public SNSSystem() {
		this.users = new UsersList();
	}

	public void add(List<String> friendsList) {
		users.add(friendsList);
	}

	public List<String> getFriendOfFriend(String name) {
		return users.getFriendOfFriend(name);
	}

	public boolean isFriends(String user, String visitor) {
		return users.isFriends(user, visitor);
	}
}
