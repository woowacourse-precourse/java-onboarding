package onboarding.problem7;

import java.util.ArrayList;
import java.util.Objects;

public class Friends {

	public static final int MAX_SIZE = 10000;
	private final ArrayList<User> friendsList;

	public Friends() {
		this.friendsList = new ArrayList<>();
	}

	public void isFull(int size) {
		if (size >= MAX_SIZE){
			throw new IllegalArgumentException("친구가 10000명입니다. 더 이상 추가할수 없습니다.");
		}
	}

	public void add(User User) {
		isFull(friendsList.size());
		friendsList.add(User);
	}

	public boolean contains(User user) {
		return friendsList.contains(user);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Friends))
			return false;
		Friends friends = (Friends)o;
		return Objects.equals(friendsList, friends.friendsList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(friendsList);
	}

	public boolean isSecondFriend(User otherUser) {
		return friendsList.stream()
			.anyMatch(user -> user != otherUser && user.isFriends(otherUser));
	}
}
