package onboarding.pagenumbergame;

import java.util.ArrayList;
import java.util.List;

public class Pages {

	private final List<Page> pages;

	public Pages(List<Integer> pageNumbers) {
		this.pages = new ArrayList<>();

		for (Integer number : pageNumbers) {
			pages.add(new Page(number));
		}
	}

	public int getScore() {
		return pages.stream()
			.map(Page::getScore)
			.max(Integer::compareTo)
			.orElse(0);
	}

	public List<Page> getPages() {
		return pages;
	}
}
