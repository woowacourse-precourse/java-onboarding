package onboarding;

import java.util.List;

import onboarding.problem7.SNSSystem;
import onboarding.problem7.TotalScoreStorage;

public class Problem7 {

	public static final int FRIEND_OF_FRIEND_SCORE = 10;
	public static final int VISITOR_SCORE = 1;

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		SNSSystem snsSystem = new SNSSystem();
		for (List<String> friendList : friends) {
			snsSystem.add(friendList);
		}

		TotalScoreStorage totalScoreStorage = new TotalScoreStorage();
		List<String> strangers = snsSystem.removeFriend(user, visitors);
		totalScoreStorage.add(strangers, VISITOR_SCORE);
		totalScoreStorage.add(snsSystem.getFriendOfFriend(user), FRIEND_OF_FRIEND_SCORE);

		return totalScoreStorage.getRecommendedFriends();
	}
}
