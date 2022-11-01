package onboarding.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Recommend {

	private final Map<String, Integer> score = new HashMap<>();
	private final String userId;

	public Recommend(String userId) {
		this.userId = userId;
		setScore();
	}

	private void setScore() {
		Set<String> userIds = UserRepository.findUserIdAll();
		for (String id : userIds) {
			if (id.equals(userId)) {
				continue;
			}
			setScore(id);
		}
	}

	private void setScore(String otherUserId) {
		addFriendScore(otherUserId);
		addVisitorsScore(otherUserId);
	}

	private void addFriendScore(String otherUserId) {
		if (FriendRepository.isFriend(userId, otherUserId)) {
			return;
		}
		Set<String> friendsNames = FriendRepository.getFriendsNames(userId);
		Set<String> otherFriendsNames = FriendRepository.getFriendsNames(otherUserId);
		if (friendsNames == null || otherFriendsNames == null) {
			return;
		}
		int friendScore = 0;
		for (String friendsName : friendsNames) {
			if (otherFriendsNames.contains(friendsName)) {
				friendScore += 10;
			}
		}
		score.put(otherUserId, score.getOrDefault(otherUserId, 0) + friendScore);
	}

	private void addVisitorsScore(String otherUserId) {
		if (FriendRepository.isFriend(userId, otherUserId)) {
			return;
		}
		score.put(otherUserId, score.getOrDefault(otherUserId, 0) + Visitors.getVisitCount(otherUserId));
	}

	public List<String> recommendTop5User() {
		Set<String> keySet = score.keySet();
		return keySet.stream()
			.sorted((a, b) -> {
				if (score.get(a).equals(score.get(b))) {
					return a.compareTo(b);
				}
				return score.get(b).compareTo(score.get(a));
			}).limit(5)
			.collect(Collectors.toList());
	}

}
