package onboarding;

import java.util.List;

import onboarding.problem7.Recommender;
import onboarding.problem7.Sns;
import onboarding.problem7.User;

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
}
