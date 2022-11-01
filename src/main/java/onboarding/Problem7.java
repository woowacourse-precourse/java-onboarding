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

		public static void addFriendRelation(User firstUser, User secondUser) {
			firstUser.friendList.add(secondUser);
			secondUser.friendList.add(firstUser);
		}
	}

	private static class SocialService {
		private final User receivedUser;
		private LinkedHashMap<String, User> users = new LinkedHashMap<>();

		SocialService(String user, List<List<String>> friends, List<String> visitors) {
			receivedUser = new User(user);
		}

		private User addUser(String name) {
			if (users.containsKey(name)) {
				return users.get(name);
			}
			User newUser = new User(name);
			users.put(name, newUser);
			return newUser;
		}

	}
}
