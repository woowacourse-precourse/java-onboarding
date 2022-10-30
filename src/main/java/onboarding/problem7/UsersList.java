package onboarding.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsersList {
	private final Map<UserID, User> usersList = new HashMap<>();

	public UsersList() {

	}

	public void add(List<String> userIDs) {
		UserID userID1 = new UserID(userIDs.get(0));
		UserID userID2 = new UserID(userIDs.get(1));
		User user1 = usersList.computeIfAbsent(userID1, User::new);
		User user2 = usersList.computeIfAbsent(userID2, User::new);
		user1.addFriend(userID2);
		user2.addFriend(userID1);
	}

	public boolean contains(UserID userID) {
		return usersList.containsKey(userID);
	}

	public List<String> getSecondFriends(String name) {
		return usersList.values().stream()
			.filter(User -> User.isSecondFriend(usersList.get(new UserID(name))))
			.map(User::toString)
			.collect(Collectors.toList());
	}
}
