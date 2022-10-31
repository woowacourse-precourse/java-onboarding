package onboarding;

import java.util.List;

import onboarding.problem7.SNSSystem;
import onboarding.problem7.TotalScoreStorage;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		SNSSystem snsSystem = new SNSSystem();
		for (List<String> friendList : friends) {
			snsSystem.add(friendList);
		}

		TotalScoreStorage totalScoreStorage = new TotalScoreStorage();
		List<String> strangers = snsSystem.removeFriend(user, visitors);
		totalScoreStorage.add(strangers, 1);
		totalScoreStorage.add(snsSystem.getFriendOfFriend(user), 10);

		return totalScoreStorage.getRecommendedFriends();
	}
}
