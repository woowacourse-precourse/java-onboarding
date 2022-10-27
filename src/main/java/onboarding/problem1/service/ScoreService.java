package onboarding.problem1.service;

import onboarding.problem1.collection.Pages;
import onboarding.problem1.vo.Page;
import onboarding.problem1.vo.Score;

public class ScoreService {
	public static Score getHighestScore(Pages pages) {
		int highestScore = Math.max(
			Math.max(
				add(pages.getFrontPage()), add(pages.getBackPage())
			),
			Math.max(
				multiply(pages.getFrontPage()), multiply(pages.getBackPage())
			)
		);
		return Score.of(highestScore);
	}

	private static Integer add(Page page) {
		return page.getEachNumberList()
			.stream().mapToInt(number -> number)
			.sum();
	}

	private static Integer multiply(Page page) {
		int result = 1;
		for (Integer number : page.getEachNumberList()) {
			result = result * number;
		}
		return result;
	}
}
