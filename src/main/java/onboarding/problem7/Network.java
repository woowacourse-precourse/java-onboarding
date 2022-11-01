package onboarding.problem7;

import java.util.List;

public class Network {

	private final Friends friends;
	private final Visit visit;

	public Network(List<List<String>> relationships, List<String> visitors) {
		this.friends = new Friends(relationships);
		this.visit = new Visit(visitors);
	}

	public int calculateScoreOf(String user, String friend) {
		int sharedFriendsCount = friends.countSharedFriends(user, friend);
		int visitCount = visit.count(friend);
		return sharedFriendsCount * 10 + visitCount;
	}
}
