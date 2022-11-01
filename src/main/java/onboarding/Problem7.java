package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

	private static class RecommendedScore {
		private final static int DEFAULT_SCORE = 0;
		private final static int SHARING_FRIEND_BONUS = 10;
		private final static int VISITED_BONUS = 1;
		private int score;

		RecommendedScore() {
			this.score = DEFAULT_SCORE;
		}

		public void addScoreBySharingFriend() {
			score += SHARING_FRIEND_BONUS;
		}

		public void addScoreByVisit() {
			score += VISITED_BONUS;
		}
	}

	private static class User {
		private final String name;
		private final RecommendedScore recommendedScore;
		private final List<User> friendList;

		public User(String name) {
			this.name = name;
			this.recommendedScore = new RecommendedScore();
			this.friendList = new ArrayList<>();
		}

		public String name() {
			return name;
		}

		public void addScoreByVisit() {
			recommendedScore.addScoreByVisit();
		}

		public void addScoreBySharingFriend() {
			recommendedScore.addScoreBySharingFriend();
		}

		public static void addFriendRelation(User firstUser, User secondUser) {
			firstUser.friendList.add(secondUser);
			secondUser.friendList.add(firstUser);
		}

		public List<String> getFriendsOfFriends() {
			List<String> friendsOfFriends = new ArrayList<>();
			for (User friend : friendList) {
				friend.friendList.stream()
					.map(User::name)
					.forEach(friendsOfFriends::add);
			}
			return friendsOfFriends;
		}
	}

	private static class SocialService {
		private final User receivedUser;
		private LinkedHashMap<String, User> users = new LinkedHashMap<>();

		SocialService(String user, List<List<String>> friends, List<String> visitors) {
			receivedUser = new User(user);
			users.put(user, receivedUser);

			for (List<String> friend : friends) {
				User firstUser = addUser(friend.get(0));
				User secondUser = addUser(friend.get(1));
				User.addFriendRelation(firstUser, secondUser);
			}
			updateScoreBySharedFriend();

			for (String visitor : visitors) {
				User currentVisitor = addUser(visitor);
				currentVisitor.addScoreByVisit();
			}
		}

		private User addUser(String name) {
			if (users.containsKey(name)) {
				return users.get(name);
			}
			User newUser = new User(name);
			users.put(name, newUser);
			return newUser;
		}

		private void updateScoreBySharedFriend() {
			List<String> sharedFriends = receivedUser.getFriendsOfFriends();
			for (String sharedFriend : sharedFriends) {
				users.get(sharedFriend).addScoreBySharingFriend();
			}
		}

	}
}
