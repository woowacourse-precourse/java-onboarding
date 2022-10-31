package onboarding.problem7;

import java.util.List;

public class SNSSystem {
	private final UsersList usersList;

	public SNSSystem() {
		this.usersList = new UsersList();
	}

	public void add(List<String> friendsList) {
		usersList.add(friendsList);
	}

	public List<String> getFriendOfFriend(String name) {
		return usersList.getFriendOfFriend(name);
	}

	public List<String> removeFriend(String user, List<String> visitor) {
		return usersList.removeFriend(user, visitor);
	}
}
