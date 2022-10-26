package onboarding.problem1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PageTest {

	@Test
	@DisplayName("점수를 가져올 수 있다")
	void calculate_score() {
		Page page = new Page(124);

		assertThat(page.calculateScore()).isEqualTo(8);
	}

	@Test
	@DisplayName("페이지는 시작면보다 커야한다")
	void page_is_greater_than_start() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Page(0));
	}

	@Test
	@DisplayName("페이지는 마지막면보다 작아야한다")
	void page_is_less_than_end() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Page(401));
	}
}
