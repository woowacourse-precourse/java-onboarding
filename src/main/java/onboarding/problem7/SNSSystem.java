package onboarding.problem7;

import static java.util.stream.Collectors.*;

import java.util.List;

public class SNSSystem {
	private final UsersList usersList;

	public SNSSystem() {
		this.usersList = new UsersList();
	}

	public void add(List<String> friendsList) {

		usersList.add(friendsList.stream()
			.map(UserID::new)
			.collect(toList()));
	}

	public List<String> getFriendOfFriend(String name) {
		return usersList.getFriendOfFriend(new UserID(name));
	}

	public List<String> removeFriend(String userID, List<String> visitor) {
		return usersList.removeFriend(new UserID(userID), visitor);
	}
}
