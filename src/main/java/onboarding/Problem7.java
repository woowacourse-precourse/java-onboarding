package onboarding;

import java.util.List;

import onboarding.problem7.Recommender;
import onboarding.problem7.Sns;
import onboarding.problem7.User;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		validateFriends(friends);
		validateVisitors(visitors);

		Sns sns = new Sns();

		for (List<String> relation : friends) {
			validateRelation(relation);

			sns.registerUser(relation.get(0));
			sns.registerUser(relation.get(1));
			sns.addRelation(relation);
		}

		for (String visitor : visitors) {
			sns.registerUser(visitor);
		}

		User targetUser = sns.findUserById(user)
				.orElseThrow(() -> new RuntimeException("NotFoundUser"));

		targetUser.addVisitors(visitors);

		Recommender recommender = new Recommender();
		List<String> recommendList = recommender.getRecommendList(user);
		sns.clear();

		return recommendList;
	}

	private static void validateVisitors(List<String> visitors) {
		if (visitors.size() > 10000) {
			throw new RuntimeException("visitors 는 10,000 이하의 길이만 가능합니다.");
		}
	}

	private static void validateRelation(List<String> relation) {
		if (relation.size() != 2) {
			throw new RuntimeException("relation 의 형식이 올바르지 않습니다.");
		}
	}

	private static void validateFriends(List<List<String>> friends) {
		if (friends.size() < 1 || friends.size() > 10000) {
			throw new RuntimeException("friends 는 1 이상 10,000 이하의 길이만 가능합니다.");
		}
	}
}
