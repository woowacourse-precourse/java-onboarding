package onboarding;

import java.util.List;

import onboarding.problem7.Assembler;
import onboarding.problem7.RecommendController;

public class Problem7 {
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		Assembler assembler = new Assembler();
		assembler.createAndWire();
		final RecommendController recommendController = assembler.getRecommendController();
		List<String> answer = recommendController.recommend(user, friends, visitors);
		return answer;
	}
}
