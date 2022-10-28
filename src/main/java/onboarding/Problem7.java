package onboarding;

import java.util.List;

import onboarding.problem7.Recommender;
import onboarding.problem7.Sns;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Sns.init(friends, visitors);
		return Recommender.recommendByUserName(user, visitors);
	}
}
