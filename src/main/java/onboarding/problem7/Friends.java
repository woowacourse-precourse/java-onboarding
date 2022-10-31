package onboarding.problem7;

import java.util.ArrayList;
import java.util.Objects;

public class Friends {

	private final ArrayList<UserID> friendsList;

	public Friends() {
		this.friendsList = new ArrayList<>();
	}

	public void add(UserID userID) {
		friendsList.add(userID);
	}

	public boolean isFriend(UserID userID) {
		return friendsList.contains(userID);
	}

	public boolean haveSameFriend(Friends friendsB) {
		return friendsList.stream()
			.anyMatch(friendsB::isFriend);
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

}
