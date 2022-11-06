package onboarding.friendrecommendationsystem.review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Users implements Iterable<User> {

	private final Set<User> users;

	public Users() {
		this.users = new HashSet<>();
	}

	public boolean addUser(final User user) {
		return users.add(user);
	}

	public User getUserById(final String userId) {
		return users.stream()
			.filter(user -> user.getId().equals(userId))
			.findAny()
			.orElse(null);
	}

	@Override
	public String toString() {
		return users.stream()
			.map(Users::toFormatString)
			.collect(Collectors.toList()).toString();
	}

	private static String toFormatString(User user) {
		StringBuilder sb = new StringBuilder();
		List<String> results = user.getFriends()
			.stream()
			.map(User::getId)
			.collect(Collectors.toList());
		sb.append(user.getId()).append(": [");
		sb.append(String.join(",", results));
		sb.append("]");
		return sb.toString();
	}

	@Override
	public Iterator<User> iterator() {
		return new UserListIterator(users);
	}

	private static class UserListIterator implements Iterator<User> {

		private final List<User> users;

		private int idx = 0;

		public UserListIterator(Set<User> users) {
			this.users = new ArrayList<>(users);
		}

		@Override
		public boolean hasNext() {
			return idx != users.size();
		}

		@Override
		public User next() {
			return users.get(idx++);
		}
	}
}
