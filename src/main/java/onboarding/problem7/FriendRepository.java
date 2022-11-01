package onboarding.problem7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FriendRepository {

	private final static Map<String, Set<String>> repository = new HashMap<>();

	static void beFriend(Friend friend) {
		addFriend(friend.getUserA().getUserId(), friend.getUserB().getUserId());
		addFriend(friend.getUserB().getUserId(), friend.getUserA().getUserId());
	}

	static void addFriend(String userAId, String userBId) {
		if (repository.containsKey(userAId)) {
			repository.get(userAId).add(userBId);
			return;
		}
		HashSet<String> set = new HashSet<>();
		set.add(userBId);
		repository.put(userAId, set);
	}

	public static boolean isFriend(String userAId, String userBId) {
		if (repository.containsKey(userAId)) {
			Set<String> friendsIds = repository.get(userAId);
			return friendsIds.contains(userBId);
		}
		return false;
	}

	public static Set<String> getFriendsNames(String userId) {
		return repository.getOrDefault(userId, null);
	}
}
