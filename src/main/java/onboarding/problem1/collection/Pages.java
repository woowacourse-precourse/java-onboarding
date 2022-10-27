package onboarding.problem1.collection;

import java.util.List;

import onboarding.problem1.vo.Page;

public class Pages {
	private final Page frontPage;
	private final Page backPage;

	private Pages(Page frontPage, Page backPage) {
		this.frontPage = frontPage;
		this.backPage = backPage;
	}

	public static Pages of(List<Integer> target) {
		return new Pages(
			Page.of(Math.min(target.get(0), target.get(1))),
			Page.of(Math.max(target.get(0), target.get(1)))
		);
	}

	public Page getFrontPage() {
		return frontPage;
	}

	public Page getBackPage() {
		return backPage;
	}
}
