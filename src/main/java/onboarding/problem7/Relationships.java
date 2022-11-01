package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Relationships {

	private final Map<String, List<String>> relationships;

	public Relationships(List<List<String>> relationships) {
		Map<String, List<String>> friends = new HashMap<>();
		for (List<String> relationship : relationships) {
			String friend = relationship.get(0);
			String otherFriend = relationship.get(1);
			friends.putIfAbsent(friend, new ArrayList<>());
			friends.putIfAbsent(otherFriend, new ArrayList<>());

			friends.get(friend).add(otherFriend);
			friends.get(otherFriend).add(friend);

			friends.get(friend).add(friend);
			friends.get(otherFriend).add(otherFriend);
		}
		this.relationships = friends;
	}

	public boolean isTwoFriends(String user, String other) {
		List<String> relationships = this.relationships.get(user);
		if(Objects.isNull(relationships)){
			return false;
		}
		return relationships.contains(other);
	}

	public Set<String> getKnownUsers() {
		return relationships.keySet();
	}

	public int countSharedFriends(String user, String other) {
		List<String> userFriends = relationships.get(user);
		List<String> otherUserFriends = relationships.get(other);
		if (Objects.isNull(userFriends) || Objects.isNull(otherUserFriends)) {
			return 0;
		}

		int count = 0;
		for (String otherUserFriend : otherUserFriends) {
			if (userFriends.contains(otherUserFriend)) {
				count += 1;
			}
		}
		return count;
	}
}
