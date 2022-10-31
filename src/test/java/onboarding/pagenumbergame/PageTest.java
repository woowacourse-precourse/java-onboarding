package onboarding.pagenumbergame;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PageTest {

	@DisplayName("페이지 번호 최대값 생성 테스트")
	@Test
	void 페이지_번호_최대값_생성() {
		Page page = new Page(List.of(97, 98));

		assertThat(page.getMaximumNumberOf(97)).isEqualTo(63);
		assertThat(page.getMaximumNumberOf(98)).isEqualTo(72);

		assertThat(page.getMaximumNumberOf(197)).isEqualTo(63);
		assertThat(page.getMaximumNumberOf(198)).isEqualTo(72);

		assertThat(page.getMaximumNumberOf(99)).isEqualTo(81);
		assertThat(page.getMaximumNumberOf(102)).isEqualTo(3);
	}

	@DisplayName("페이지 최대값 생성 테스트")
	@Test
	void 페이지_최대값_생성_테스트() {
		Page page = new Page(List.of(97, 98));
		assertThat(page.getMaximumScore()).isEqualTo(72);

		page = new Page(List.of(211, 212));
		assertThat(page.getMaximumScore()).isEqualTo(5);
	}

	@DisplayName("페이지 비교 테스트::예시 1")
	@Test
	void 페이지_생성_예시1() {
		Page pobi = new Page(List.of(97, 98));
		Page crong = new Page(List.of(197, 198));
		assertThat(pobi.compare(crong)).isEqualTo(0);
	}

	@DisplayName("페이지 비교 테스트::예시 2")
	@Test
	void 페이지_생성_예시2() {
		Page pobi = new Page(List.of(131, 132));
		Page crong = new Page(List.of(211, 212));
		assertThat(pobi.compare(crong)).isEqualTo(1);
		assertThat(crong.compare(pobi)).isEqualTo(2);
	}

	@DisplayName("페이지 비교 테스트::예시 3")
	@Test
	void 페이지_생성_예시3() {
		Page pobi = new Page(List.of(99, 102));
		Page crong = new Page(List.of(211, 212));
		assertThat(pobi.compare(crong)).isEqualTo(-1);
	}
}
