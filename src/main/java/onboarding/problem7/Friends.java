package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Friends {

	private final Map<String, List<String>> relationships;

	public Friends(List<List<String>> relationships) {
		Map<String, List<String>> relationshipsMap = new HashMap<>();
		for (List<String> relationship : relationships) {
			String friend = relationship.get(0);
			String otherFriend = relationship.get(1);
			relationshipsMap.putIfAbsent(friend, new ArrayList<>());
			relationshipsMap.putIfAbsent(otherFriend, new ArrayList<>());
			relationshipsMap.get(friend).add(otherFriend);
			relationshipsMap.get(otherFriend).add(friend);
		}
		this.relationships = relationshipsMap;
	}

	public boolean isTwoFriends(String friend, String other) {
		return relationships.get(friend).contains(other);
	}
}
