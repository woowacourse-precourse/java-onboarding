package onboarding.problem7;

import java.util.List;

public class RecommendResult {

	List<String> result;

	public RecommendResult(String inputUserId, List<List<String>> inputFriends,
		List<String> inputVisitorsId) {
		persist(inputUserId, inputFriends, inputVisitorsId);
		Recommend recommend = new Recommend(inputUserId);
		this.result = recommend.recommendTop5User();
	}

	void persist(String inputUserId, List<List<String>> inputFriends,
		List<String> inputVisitorsId) {
		new User(inputUserId);
		new InputFriends(inputFriends);
		Visitors.init(inputVisitorsId);
	}

	public List<String> getResult() {
		return result;
	}
}
