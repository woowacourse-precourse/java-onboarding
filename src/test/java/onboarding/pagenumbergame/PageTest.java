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

		assertThat(page.getMaximumNumberFrom(97)).isEqualTo(63);
		assertThat(page.getMaximumNumberFrom(98)).isEqualTo(72);

		assertThat(page.getMaximumNumberFrom(197)).isEqualTo(63);
		assertThat(page.getMaximumNumberFrom(198)).isEqualTo(72);

		assertThat(page.getMaximumNumberFrom(99)).isEqualTo(81);
		assertThat(page.getMaximumNumberFrom(102)).isEqualTo(3);
	}
}
