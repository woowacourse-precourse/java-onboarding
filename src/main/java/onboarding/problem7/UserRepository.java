package onboarding.problem7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserRepository {

	private final static Map<String, User> repository = new HashMap<>();

	public static void join(User user) {
		repository.putIfAbsent(user.getUserId(), user);
	}

	public static Set<String> findUserIdAll() {
		return repository.keySet();
	}
}
