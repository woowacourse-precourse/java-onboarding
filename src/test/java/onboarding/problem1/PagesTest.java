package onboarding.problem1;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PagesTest {

	@Test
	@DisplayName("최대 점수를 계산할 수 있다")
	void calculate_maximum_score() {
		List<Integer> pageNumbers = List.of(97, 98);
		Pages pages = new Pages(pageNumbers);

		Assertions.assertThat(pages.calculateScore()).isEqualTo(72);
	}
}
