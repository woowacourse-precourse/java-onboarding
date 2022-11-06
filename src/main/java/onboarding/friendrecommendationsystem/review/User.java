package onboarding.friendrecommendationsystem.review;

import java.util.HashSet;
import java.util.Set;

public class User {

	private static final int MIN_ID_LENGTH = 1;

	private static final int MAX_ID_LENGTH = 10_000;

	private final String id;

	private final Set<User> friends;

	public User(final String id) {
		validateId(id);
		this.id = id;
		this.friends = new HashSet<>();
	}

	private void validateId(final String id) {
		if (isOutOfBound(id) || !isAllLowercase(id)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isAllLowercase(final String id) {
		return id.chars()
			.allMatch(Character::isLowerCase);
	}

	private boolean isOutOfBound(final String id) {
		int length = id.length();
		return MIN_ID_LENGTH > length || length > MAX_ID_LENGTH;
	}

	public boolean addFriend(final User user) {
		return friends.add(user);
	}

	public boolean isFriendWith(final User user) {
		return friends.contains(user);
	}

	public Set<User> getFriends() {
		return friends;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		User other = (User)o;
		return this.id.equals(other.id);
	}

	@Override
	public int hashCode() {
		int prime = 31;
		return prime + (id == null ? 0 : id.hashCode());
	}

	public int getNumberOfFriendsKnowWith(final User other) {
		return (int)friends.stream()
			.filter(other::isFriendWith)
			.count();
	}

	public String getId() {
		return id;
	}

	public int compareTo(User other) {
		return this.id.compareTo(other.id);
	}
}
