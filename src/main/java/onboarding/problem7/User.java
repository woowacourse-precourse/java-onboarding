package onboarding.problem7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	private final String id;
	private final Set<User> friendSet;
	private final Map<String, Integer> visitorMap;

	public User(String id) {
		this.id = validateId(id);
		this.friendSet = new HashSet<>();
		this.visitorMap = new HashMap<>();
	}

	public void addFriend(User id) {
		friendSet.add(id);
	}

	public void addVisitors(List<String> visitors) {
		for (String visitor : visitors) {
			if (id.equals(visitor)) {
				continue;
			}
			Integer visitScore = visitorMap.getOrDefault(visitor, 0);
			visitorMap.put(visitor, visitScore + 1);
		}
	}

	public Set<User> getFriendSet() {
		return friendSet;
	}

	public Map<String, Integer> getVisitorMap() {
		return visitorMap;
	}

	public String getId() {
		return id;
	}

	private String validateId(String id) {
		if (id.length() < 1 || id.length() > 30) {
			throw new RuntimeException("Id 는 1자 이상 30자 이하의 길이만 가능합니다.");
		} else if (!id.matches("^[a-z]*$")) {
			throw new RuntimeException("Id 는 소문자만 사용 가능합니다.");
		}
		return id;
	}
}
