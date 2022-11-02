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
		Map<String, List<String>> relationshipsMap = new HashMap<>();
		for (List<String> relationship : relationships) {
			String friend = relationship.get(0);
			String otherFriend = relationship.get(1);
			relationshipsMap.putIfAbsent(friend, new ArrayList<>());
			relationshipsMap.putIfAbsent(otherFriend, new ArrayList<>());

			relationshipsMap.get(friend).add(otherFriend);
			relationshipsMap.get(otherFriend).add(friend);
			relationshipsMap.get(friend).add(friend);
			relationshipsMap.get(otherFriend).add(otherFriend);
		}
		this.relationships = relationshipsMap;
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
		return countShared(userFriends, otherUserFriends);
	}

	private int countShared(List<String> userFriends, List<String> otherUserFriends) {
		int count = 0;
		for (String otherUserFriend : otherUserFriends) {
			if (userFriends.contains(otherUserFriend)) {
				count += 1;
			}
		}
		return count;
	}
}
