package onboarding.problem1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PageTest {

	@Test
	@DisplayName("점수를 가져올 수 있다")
	void calculate_score() {
		Page page = new Page(124);

		Assertions.assertThat(page.calculateScore()).isEqualTo(8);
	}
}
