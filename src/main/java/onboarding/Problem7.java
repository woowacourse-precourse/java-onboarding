package onboarding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Sns sns = new Sns();

		for (List<String> relation : friends) {
			sns.initUser(relation.get(0));
			sns.initUser(relation.get(1));
			sns.addRelation(relation);
		}

		for (String visitor : visitors) {
			sns.initUser(visitor);
		}

		User targetUser = sns.findUserById(user)
				.orElseThrow(() -> new RuntimeException("NotFoundUser"));

		targetUser.addVisitors(visitors);

		Recommender recommender = new Recommender();
		return recommender.getRecommendList(user);
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

		public Set<User> getFriendSet() {
			return friendSet;
		}

		public Map<String, Integer> getVisitorMap() {
			return visitorMap;
		}

		public String getId() {
			return id;
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

		public Map<String, User> getUserMap() {
			return userMap;
		}
	}

	static class Recommender {

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
}
