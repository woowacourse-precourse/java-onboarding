package onboarding.problem7;

import java.util.Objects;

public class User {
	private final Friends friends;
	private final String userID;

	public User(String userID) {
		this.userID = userID;
		this.friends = new Friends();
	}

	public void addFriend(User friend) {
		this.friends.add(friend);
	}

	public boolean isFriends(User otherUser) {
		return this.friends.contains(otherUser);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;
		User user = (User)o;
		return Objects.equals(friends, user.friends) && Objects.equals(userID, user.userID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(friends, userID);
	}

	public boolean isSecondFriend(User otherUser) {
		return friends.isSecondFriend(otherUser);
	}
}
