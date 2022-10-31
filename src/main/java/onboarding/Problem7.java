package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Sns sns = new Sns();

		for (List<String> relation : friends) {
			sns.initUser(relation.get(0));
			sns.initUser(relation.get(1));
			sns.addRelation(relation);
		}

		User targetUser = sns.findUserById(user)
				.orElseThrow(() -> new RuntimeException("NotFoundUser"));

		targetUser.addVisitors(visitors);

		return null;
	}

	static class User {
		private final String id;
		private final Set<User> friendSet;
		private final Map<String, Integer> visitorMap;

		public User(String id) {
			this.id = id;
			this.friendSet = new HashSet<>();
			this.visitorMap = new HashMap<>();
		}

		public void addFriend(User id) {
			friendSet.add(id);
		}

		public void addVisitors(List<String> visitors) {
			for (String visitor : visitors) {
				Integer visitScore = visitorMap.getOrDefault(visitor, 0);
				visitorMap.put(visitor, visitScore + 1);
			}
		}
	}

	static class Sns {
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
	}
}
