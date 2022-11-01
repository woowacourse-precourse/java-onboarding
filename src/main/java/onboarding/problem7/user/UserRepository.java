package onboarding.problem7.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

	private final Map<String, User> userRepository = new HashMap<>();

	public synchronized User getUserByNickname(String nickname) {
		return userRepository.computeIfAbsent(nickname, n -> new User(nickname));
	}

	public List<User> getAllUser() {
		return new ArrayList<>(userRepository.values());
	}
}
