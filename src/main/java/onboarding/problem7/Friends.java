package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Friends {

	private final Map<String, List<String>> friends;

	public Friends(List<List<String>> relationships) {
		Map<String, List<String>> friends = new HashMap<>();
		for (List<String> relationship : relationships) {
			String friend = relationship.get(0);
			String otherFriend = relationship.get(1);
			friends.putIfAbsent(friend, new ArrayList<>());
			friends.putIfAbsent(otherFriend, new ArrayList<>());
			friends.get(friend).add(otherFriend);
			friends.get(otherFriend).add(friend);
		}
		this.friends = friends;
	}

	public boolean isTwoFriends(String user, String other) {
		return friends.get(user).contains(other);
	}

	public int countSharedFriends(String user, String other) {
		List<String> userFriends = friends.get(user);
		List<String> otherUserFriends = friends.get(other);

		int count = 0;
		for (String otherUserFriend : otherUserFriends) {
			if (userFriends.contains(otherUserFriend)) {
				count += 1;
			}
		}
		return count;
	}
}
