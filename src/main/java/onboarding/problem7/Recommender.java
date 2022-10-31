package onboarding.problem7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Recommender {

	private Sns sns;

	public Recommender() {
		this.sns = new Sns();
	}

	public List<String> getRecommendList(String targetId) {
		User targetUser = sns.findUserById(targetId)
				.orElseThrow(() -> new RuntimeException("NotFoundUser"));

		Map<String, User> userMap = sns.getUserMap();
		Set<User> friendSet = targetUser.getFriendSet();
		Map<String, Integer> visitorMap = targetUser.getVisitorMap();

		Map<String, Integer> recommendScoreMap = new HashMap<>();
		for (String userId : userMap.keySet()) {
			User user = userMap.get(userId);
			if (isFriends(targetUser, user) || targetUser.equals(user)) {
				continue;
			} else {
				int score = 0;

				for (User friend : friendSet) {
					if (isFriends(user, friend)) {
						score += 10;
					}
				}

				score += visitorMap.getOrDefault(userId, 0);
				recommendScoreMap.put(userId, score);
			}
		}

		List<String> recommendList = recommendScoreMap
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue() > 0)
				.sorted(Map.Entry.comparingByKey())
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());


		if (recommendList.size() > 5) {
			return recommendList.subList(0, 5);
		} else {
			return recommendList;
		}
	}

	private boolean isFriends(User user, User friend) {
		return user.getFriendSet().contains(friend);
	}
}
