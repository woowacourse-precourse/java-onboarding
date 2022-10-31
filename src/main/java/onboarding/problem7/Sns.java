package onboarding.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Sns {
	public static final Map<String, User> userMap = new HashMap<>();

	public Sns() {
	}

	public void initUser(String id) {
		if (!userMap.containsKey(id)) {
			User user = new User(id);
			userMap.put(id, user);
		}
	}

	public Optional<User> findUserById(String id) {
		if (userMap.containsKey(id)) {
			User user = userMap.get(id);
			return Optional.ofNullable(user);
		} else {
			return Optional.empty();
		}
	}

	public void addRelation(List<String> relation) {
		User user1 = findUserById(relation.get(0))
				.orElseThrow(() -> new RuntimeException("NotFoundUser"));
		User user2 = findUserById(relation.get(1))
				.orElseThrow(() -> new RuntimeException("NotFoundUser"));

		user1.addFriend(user2);
		user2.addFriend(user1);
	}

	public Map<String, User> getUserMap() {
		return userMap;
	}
}
