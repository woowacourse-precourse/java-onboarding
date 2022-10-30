package onboarding.problem7;

import java.util.ArrayList;
import java.util.Objects;

public class Friends {

	private final ArrayList<Object> friendsList;

	public Friends() {
		this.friendsList = new ArrayList<>();
	}

	public void add(User User) {
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
}
