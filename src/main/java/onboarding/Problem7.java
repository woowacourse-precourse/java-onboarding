package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Sns sns = new Sns();

		for(List<String> relation : friends) {
			sns.initUser(relation.get(0));
			sns.initUser(relation.get(1));
		}

		return null;
	}

	static class User {
		private final String id;

		public User(String id) {
			this.id = id;
		}
	}

	static class Sns {
		public static final HashMap<String, User> userMap = new HashMap<>();

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
	}
}
