package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import onboarding.Page;

public class PageTest {

	@Test
	void 첫_페이지_검증() {
		Page page = new Page(1, 2);
		assertThat(page.isFirstPage()).isTrue();
	}

	@Test
	void 마지막_페이지_검증() {
		Page page = new Page(399, 400);
		assertThat(page.isLastpage()).isTrue();
	}

	@Test
	void 예외_페이지_검증() {
		Page page = new Page(1, 5);
		assertThat(page.isValid()).isFalse();
	}
}
