package onboarding.problem7;

import java.util.List;

public class Friend {
	private final User userA;
	private final User userB;

	public Friend(List<String> inputFriend) {
		this.userA = new User(inputFriend.get(0));
		this.userB = new User(inputFriend.get(1));
		FriendRepository.beFriend(this);
	}

	public User getUserA() {
		return userA;
	}

	public User getUserB() {
		return userB;
	}
}
